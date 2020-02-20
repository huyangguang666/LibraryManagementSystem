package com.myproject.bookmanager.service.impl;

import com.myproject.bookmanager.dao.UserDao;
import com.myproject.bookmanager.model.User;
import com.myproject.bookmanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUser(int uid) {
        return userDao.selectById(uid);
    }

    @Override
    public User getUser(String email) {
        return userDao.selectByEmail(email);
    }
}
