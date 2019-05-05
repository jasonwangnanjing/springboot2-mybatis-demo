package com.jw.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class TokenAuthenticationService {
    static final long EXPIRATIONTIME = 9999999999L;     // duration of a token
    static final String SECRET = "P@ssw02d";            // JWT secret to encrypt content
    static final String TOKEN_PREFIX = "Bearer";        // Token prefix
    static final String HEADER_STRING = "Authorization";// HTTP Header Key to store "Authorization"

    static void addAuthentication(HttpServletResponse response, Authentication auth) {

        //prepare auth string based on user's assigned roles and authorities
        String authString = new String();
        for (GrantedAuthority authImpl : auth.getAuthorities()
        ) {
            authString = authImpl.getAuthority() + "," + authString ;
        }

        // Generate JWT
        String JWT = Jwts.builder()
                // take authorities strings
                .claim("authorities", authString)
                // set user name into subject
                .setSubject(auth.getName())
                // set expiration time
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                // set signature
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();

        // set JWT token into response body
        try {
            response.setContentType("application/json");
            response.setStatus(HttpServletResponse.SC_OK);
            response.getOutputStream().println(JSONResult.fillResultString(0, "", JWT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static Authentication getAuthentication(HttpServletRequest request) {
        // get token from header string
        String token = request.getHeader(HEADER_STRING);

        if (token != null) {
            // parser Token
            Claims claims = Jwts.parser()
                    // check Signature
                    .setSigningKey(SECRET)
                    // remove leading  Bearer
                    .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                    .getBody();

            // get user name from subject
            String user = claims.getSubject();

            // get roles/authorities
            List<GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList((String) claims.get("authorities"));

            // return tocken
            return user != null ?
                    new UsernamePasswordAuthenticationToken(user, null, authorities) :
                    null;
        }
        return null;
    }
}
