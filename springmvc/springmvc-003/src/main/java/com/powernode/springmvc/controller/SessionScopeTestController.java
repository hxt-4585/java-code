package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes(value = {"x", "y"})
public class SessionScopeTestController {
    @RequestMapping("/testSessionScope")
    public String testSessionScope(HttpSession session){
        session.setAttribute("testSessionScope", "使用原生Servlet API实现session域共享数据");
        return "view";
    }

    @RequestMapping("/testSessionScopeByAnno")
    public String testSessionScopeByAnno(ModelMap modelMap){
        modelMap.addAttribute("x","I am x");
        modelMap.addAttribute("y","I am y");
        return "view";
    }
}
