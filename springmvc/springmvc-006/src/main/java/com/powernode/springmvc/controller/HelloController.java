package com.powernode.springmvc.controller;

import com.powernode.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    @GetMapping("/hello")
//    public void hello(HttpServletResponse response) throws IOException {
//        response.getWriter().print("hello");
//    }

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return  "{\"username\":\"zhangsan\",\"password\":\"1234\"}";
    }

//    @RequestMapping(value = "/hello")
//    public User hello(){
//        User user = new User("zhangsan", "22222");
//        return user;
//    }

    @PostMapping(value = "/save")
    public String saveByPost(@RequestBody String requestBodyStr){
        System.out.println("请求体：" + requestBodyStr);
        return "ok";
    }

    @PostMapping("/send")
    @ResponseBody
    public String send(@RequestBody User user){
        System.out.println(user);
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        return "ok";
    }
}
