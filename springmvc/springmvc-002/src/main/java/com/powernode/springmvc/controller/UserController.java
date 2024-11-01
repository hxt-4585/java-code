package com.powernode.springmvc.controller;

import com.powernode.springmvc.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class UserController {

    @RequestMapping("toRegister")
    public String toRegister(){
        return "register";
    }

//    @PostMapping("/register")
//    public String register(HttpServletRequest request){
//        // 通过当前请求对象获取提交的数据
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        String sex = request.getParameter("sex");
//        String[] hobbies = request.getParameterValues("hobby");
//        String intro = request.getParameter("intro");
//        System.out.println(username + "," + password + "," + sex + "," + Arrays.toString(hobbies) + "," + intro);
//        return "success";
//    }

//    @PostMapping("/register")
//    public String register(
//            @RequestParam("username")String username,
//            @RequestParam("password")String password,
//            @RequestParam("sex")String sex,
//            @RequestParam(value = "hobby", defaultValue = "smoke,drink")String[] hobby,
//            @RequestParam(value = "intro", required = false)String intro
//    ){
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(sex);
//        System.out.println(Arrays.toString(hobby));
//        System.out.println(intro);
//        return "success";
//    }

    @PostMapping("/register")
    public String register(String username, String password, String sex, String[] hobby, String intro){
        System.out.println(username);
        System.out.println(password);
        System.out.println(sex);
        System.out.println(Arrays.toString(hobby));
        System.out.println(intro);
        return "success";
    }

    @PostMapping("/registerByObject")
    public String registerByObject(User user, @RequestHeader("accept")String accept){
        System.out.println(user);
        System.out.println(accept);
        return "success";
    }

}
