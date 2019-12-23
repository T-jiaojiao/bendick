package com.xr.springboot1.service.impl;

import com.xr.springboot1.dao.UserMapper;
import com.xr.springboot1.model.User;
import com.xr.springboot1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> query() {
        return userMapper.query();
    }
}
