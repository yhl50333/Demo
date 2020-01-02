package com.example.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface CTMapper {
    void insert(String name,String info);
}
