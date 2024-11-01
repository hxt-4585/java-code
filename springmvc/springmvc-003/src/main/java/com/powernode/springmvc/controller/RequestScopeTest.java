package com.powernode.springmvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class RequestScopeTest {
    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        request.setAttribute("testRequestScope", "在SpringMVC中使用原生Servlet API实现request域数据共享");
        return "view";
    }

    @RequestMapping("/testModel")
    public String testModel(Model model){
        // 向request域中存储数据
        model.addAttribute("testRequestScope", "在SpringMVC中使用Model接口实现request域数据共享");
        System.out.println(model.getClass().getName());
        return "view";
    }

    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        // 向request域中存储数据
        map.put("testRequestScope", "在SpringMVC中使用Map接口实现request域数据共享");
        System.out.println(map.getClass().getName());
        return "view";
    }

    @RequestMapping("/testModelMap")
    public String testModelMap(ModelMap modelMap){
        // 向request域中存储数据
        modelMap.addAttribute("testRequestScope", "在SpringMVC中使用ModelMap实现request域数据共享");
        System.out.println(modelMap.getClass().getName());
        return "view";
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("view");
        modelAndView.addObject("testRequestScope", "在SpringMVC中使用ModelAndView实现request域数据共享");
        return modelAndView;
    }
}
