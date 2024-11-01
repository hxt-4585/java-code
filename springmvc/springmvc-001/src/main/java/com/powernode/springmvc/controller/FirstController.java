package com.powernode.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FirstController {

    @RequestMapping("/first")
    public String firstProgram(){
        return "first";
    }

    @RequestMapping(value = {"/x?z/testValue1", "/testValue2"})
    public String fuzzyMatching(){
        return "first";
    }

}
