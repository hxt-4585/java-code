package com.powernode.springmvc.controller;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationScopeTestController {
    @RequestMapping("/testApplicationScope")
    public String testApplicationScope(HttpServletRequest request){

        // 获取ServletContext对象
        ServletContext application = request.getServletContext();

        // 向应用域中存储数据
        application.setAttribute("applicationScope", "我是应用域当中的一条数据");

        return "view";
    }
}
