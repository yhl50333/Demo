package com.example.service;

import com.example.entity.Keh;
import com.example.mapper.KehMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Kehservice {
    @Autowired
    KehMapper khm;
    public Keh Sel(int id){
        return khm.Sel(id);
    }
}
