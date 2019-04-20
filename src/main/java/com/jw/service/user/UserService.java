package com.jw.service.user;

import com.github.pagehelper.PageInfo;
import com.jw.model.User;

/**
 * Created by Administrator on 2018/4/19.
 */
public interface UserService {

    int addUser(User user);

    PageInfo<User> findAllUser(int pageNum, int pageSize);
}
