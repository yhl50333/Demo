package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ManagerController {
    @RequestMapping("/addMainClassify")
    public String addMainClassify(@RequestParam (value="name")String name,@RequestParam(value = "info")String info){
    System.out.println(name);
    System.out.println(info);
    String c=null;
    return c;
    }

}
