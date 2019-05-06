package com.jw.config;


import com.jw.security.CustomAuthenticationProvider;
import com.jw.security.JWTAuthenticationFilter;
import com.jw.security.JWTLoginFilter;
import com.jw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//enable authorization and authication on method level
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {

        // close csrf
        http.csrf().disable()
                // authorize request
                .authorizeRequests()
                // allow post method to get token
                .antMatchers(HttpMethod.POST, "/token").permitAll()
                // add security check for certain url
                .antMatchers("/order/*").hasAuthority("AUTH_WRITE")
                // check role for certain url
                .antMatchers("/user").hasRole("ADMIN")
                // any other request need authentication
                .anyRequest().authenticated()
                .and()
                // to get token, it need use special filter which validate user name password
                .addFilterBefore(new JWTLoginFilter("/token", authenticationManager()),
                        UsernamePasswordAuthenticationFilter.class)
                // other request need validate token
                .addFilterBefore(new JWTAuthenticationFilter(),
                        UsernamePasswordAuthenticationFilter.class);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 使用自定义身份验证组件
        auth.authenticationProvider(new CustomAuthenticationProvider(sysUserService, bCryptPasswordEncoder));
    }

}
