package com.jw.service;

import com.github.pagehelper.PageInfo;
import com.jw.model.SysUser;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(SysUser sysUser);

    int updateUser(SysUser sysUser);

    PageInfo<SysUser> findAllUser(int pageNum, int pageSize);
}
