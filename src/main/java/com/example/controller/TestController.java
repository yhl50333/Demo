package com.example.controller;


import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {
    @RequestMapping("1")
    public String c(){

        return "myPage";
    }

    @RequestMapping("login")
    public  String login(){
        return "login";

    }
}
