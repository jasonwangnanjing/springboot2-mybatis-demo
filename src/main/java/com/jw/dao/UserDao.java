package com.jw.dao;


import com.jw.model.SysUser;

import java.util.List;

public interface UserDao {


    int insert(SysUser record);

    int updateUser(SysUser sysUser);

    List<SysUser> selectUsers();

    SysUser getUserByName(String userName);
}