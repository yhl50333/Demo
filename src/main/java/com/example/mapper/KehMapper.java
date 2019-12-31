package com.example.mapper;


import com.example.entity.Keh;
import org.springframework.stereotype.Repository;

@Repository
public interface KehMapper {
    Keh Sel(int id);
}
