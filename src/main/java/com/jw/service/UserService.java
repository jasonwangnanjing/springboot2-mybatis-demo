package com.jw.service;

import com.github.pagehelper.PageInfo;
import com.jw.model.User;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(User user);

    int updateUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
