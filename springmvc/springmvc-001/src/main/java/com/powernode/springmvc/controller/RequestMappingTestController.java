package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RequestMappingTestController {
    @RequestMapping("/testRESTful/{id}/{username}/{age}")
    public String testRESTful(
            @PathVariable("id")int id,
            @PathVariable("username")String username,
            @PathVariable("age")int age
    ){
        System.out.println(id + "," + username + "," + age);
        return "testRESTful";    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String testMethod(){
        return "testMethod";
    }


}
