package com.powernode.spring6.service.impl;

import com.powernode.spring6.dao.UserDao;
import com.powernode.spring6.dao.VipDao;
import com.powernode.spring6.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;
    private VipDao vipDao;

    public UserServiceImpl(UserDao userDao, VipDao vipDao) {
        this.userDao = userDao;
        this.vipDao = vipDao;
    }
//    public void setUserDao(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public void save() {
        userDao.insert();
        vipDao.insert();
    }
}
