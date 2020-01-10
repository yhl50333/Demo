package com.example.service;

import com.example.dao.UserService;
import com.example.entity.User;
import com.example.entity.UserInfo;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public  class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User getByName(String username) {
        return userMapper.getByName(username);
    }

    @Override
    public User querybyname(String phone) {
        return userMapper.querybyname(phone);


    }

    @Override
    public UserInfo queryuserinfo(int uid) {
        return userMapper.queryuserinfo(uid);
    }

}

