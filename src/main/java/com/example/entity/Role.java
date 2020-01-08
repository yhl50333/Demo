package com.example.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
@Getter
@Setter
public class Role implements Serializable {
    private Long id;
    private String name;
    private Set<Permission> permissions = new HashSet<>();
    private Set<User> users=new HashSet<>();


}
