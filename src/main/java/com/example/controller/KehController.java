package com.example.controller;

import com.example.service.KehDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class KehController {
    @Autowired
    private KehDao khs;
    @RequestMapping("logout/1")
    public String GetKeh(@PathVariable int id){

        return khs.Sel(id).toString();
    }

}
