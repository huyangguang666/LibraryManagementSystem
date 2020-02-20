package com.myproject.bookmanager.service;

import com.myproject.bookmanager.model.User;

public interface UserService {

    /**
     * 添加用户
     * @param user
     * @return
     */
    int addUser(User user);

    /**
     * 根据用户id获取用户信息
     * @param uid
     * @return
     */
    User getUser(int uid);

    /**
     * 根据email获取用户信息
     * @param email
     * @return
     */
    User getUser(String email);
}
