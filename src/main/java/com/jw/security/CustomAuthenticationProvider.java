package com.jw.security;

import com.jw.dao.UserDao;
import com.jw.model.Permission;
import com.jw.model.Role;
import com.jw.model.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

// 自定义身份认证验证组件
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        // 获取认证的用户名 & 密码
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        SysUser user = userDao.getUserByName(name);

        // 认证逻辑
        if ((user != null) && password.equals(user.getPassword())) {

            //get user's roles.
            ArrayList<GrantedAuthority> authorities = new ArrayList<>();
            ArrayList<Permission> permissions = new ArrayList<>();

            List<Role> roles = user.getRoles();

            roles.forEach(role -> authorities.add(new GrantedAuthorityImpl("ROLE_" + role.getName())));

            roles.forEach(role -> permissions.addAll(role.getPermission()));

            permissions.forEach(permission -> authorities.add(new GrantedAuthorityImpl("AUTO_" + permission.getName())));

            // 生成令牌
            Authentication auth = new UsernamePasswordAuthenticationToken(name, password, authorities);
            return auth;
        } else {
            throw new BadCredentialsException("密码错误~");
        }
    }

    // 是否可以提供输入类型的认证服务
    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
