package com.jw.dao;


import com.jw.model.User;

import java.util.List;

public interface UserDao {


    int insert(User record);

    int updateUser(User user);

    List<User> selectUsers();
}