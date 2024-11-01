package com.powernode.spring.service.impl;

import com.powernode.spring.dao.UserDao;
import com.powernode.spring.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        userDao.insert();
    }
}
