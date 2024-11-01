package com.powernode.spring6.dao;

public class UserDao {
    public UserDao() {
        System.out.println(this);
    }

    public void insert(){
        System.out.println("正在保存用户数据。");
    }
}
