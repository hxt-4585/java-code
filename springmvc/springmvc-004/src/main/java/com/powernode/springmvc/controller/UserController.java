package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @GetMapping("/api/user/{id}")
    public String getById(@PathVariable Integer id){
        System.out.println(id);
        return "ok";
    }

    @GetMapping("/api/user")
    public String getAll(){
        System.out.println("查询所有用户信息");
        return "ok";
    }

    @PostMapping("/api/user")
    public String save(){
        System.out.println("保存");
        return "ok";
    }

    @PutMapping("/api/user")
    public String modify( String username){
        System.out.println(username);
        return "ok";
    }

}
