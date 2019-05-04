package com.jw.service;

import com.github.pagehelper.PageInfo;
import com.jw.model.SysUser;

import java.util.List;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface SysUserService {

    int addUser(SysUser sysUser);

    int updateUser(SysUser sysUser);

    List<SysUser> findAllUser();

    SysUser getUserRolesPermissions(String userName);
}
