package com.powernode.springmvc.controller;

import com.powernode.springmvc.bean.User;
import com.powernode.springmvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserDao userDao;

    @GetMapping("/user")
    public String list(Model model){
        List<User> users = userDao.selectAll();
        model.addAttribute("users", users);
        return "user_list";
    }

    @PostMapping("/add")
    public String add(User user){
        user.setId(1006L);
        Boolean flag = userDao.add(user);
        System.out.println(flag);
        return "redirect:/user";
    }
}
