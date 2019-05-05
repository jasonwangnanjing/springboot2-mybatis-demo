package com.jw.service.impl;

import com.jw.dao.UserDao;
import com.jw.model.SysUser;
import com.jw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public int addUser(SysUser sysUser) {
        String userPW = bCryptPasswordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(userPW);

        return userDao.insert(sysUser);
    }

    @Override
    public int updateUser(SysUser sysUser) {

        String userPW = bCryptPasswordEncoder.encode(sysUser.getPassword());
        sysUser.setPassword(userPW);
        return userDao.updateUser(sysUser);
    }

    @Override
    public final List<SysUser> findAllUser() {
        return  userDao.selectUsers() ;
    }

    @Override
    public final SysUser getUserRolesPermissions(String userName) {
        return userDao.getUserRolesPermissions(userName);
    }
}
