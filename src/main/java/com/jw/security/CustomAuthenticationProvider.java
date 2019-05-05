package com.jw.security;

import com.jw.model.Permission;
import com.jw.model.Role;
import com.jw.model.SysUser;
import com.jw.service.SysUserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

// 自定义身份认证验证组件
@Service(value = "CustomAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {


    private SysUserService sysUserService;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    private final int USERDISABLED = 1;

    public CustomAuthenticationProvider(SysUserService sysUserService, BCryptPasswordEncoder bCryptPasswordEncoder) {

        this.sysUserService = sysUserService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//    @Autowired
//    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // get user name and password posted
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        SysUser user = sysUserService.getUserRolesPermissions(name);

        if (user.getStatus() == USERDISABLED) {


            throw new DisabledException("user: " + name + " disabled already.");
        }

        // validate user name and password
        if ((user != null) && bCryptPasswordEncoder.matches(password, user.getPassword())) {

            //get user's roles.
            List<GrantedAuthority> authorities = new ArrayList<>();
            List<Permission> permissions = new ArrayList<>();

            List<Role> roles = user.getRoles();

            for (Role role : roles) {

                if (role.getRoleName() != null) {

                    authorities.add(new GrantedAuthorityImpl("ROLE_" + role.getRoleName()));
                    permissions.addAll(role.getPermissions());
                }
            }
            for (Permission permission : permissions) {

                authorities.add(new GrantedAuthorityImpl("AUTH_" + permission.getPermissionName()));
            }

            // generate token
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;
        } else {
            throw new BadCredentialsException("Bad user name or password");
        }
    }

    // supper user name password authentication
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
