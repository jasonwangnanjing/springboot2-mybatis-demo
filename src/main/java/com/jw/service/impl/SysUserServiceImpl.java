package com.jw.service.impl;

import com.jw.dao.UserDao;
import com.jw.model.SysUser;
import com.jw.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private UserDao userDao;


    @Override
    public int addUser(SysUser sysUser) {
        return userDao.insert(sysUser);
    }

    @Override
    public int updateUser(SysUser sysUser) {
        return userDao.updateUser(sysUser);
    }

    @Override
    public List<SysUser> findAllUser() {
        return  userDao.selectUsers() ;
    }

    @Override
    public SysUser getUserRolesPermissions(String userName) {
        return userDao.getUserRolesPermissions(userName);
    }
}
