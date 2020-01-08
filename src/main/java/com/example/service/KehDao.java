package com.example.service;

import com.example.entity.Keh;
import com.example.mapper.KehMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class KehDao {
    @Autowired
    KehMapper keh;
    public Keh Sel(int id){
        return keh.Sel(id);
    }
}
