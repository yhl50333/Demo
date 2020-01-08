package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Setter
@Getter
public class User {
    private Integer uid;
    private String password;//密码
    private String username;
    private Set<Role> roles=new HashSet<>();

}
