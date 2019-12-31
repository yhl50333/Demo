package com.example.controller;

import com.example.service.Kehservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testBoot")
public class KehController {
    @Autowired
    private Kehservice khs;
    @RequestMapping("getUser/{id}")
    public String GetKeh(@PathVariable int id){

        return khs.Sel(id).toString();
    }

}
