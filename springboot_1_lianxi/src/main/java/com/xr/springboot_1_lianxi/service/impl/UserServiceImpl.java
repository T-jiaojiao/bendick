package com.xr.springboot_1_lianxi.service.impl;

import com.xr.springboot_1_lianxi.dao.UserMapper;
import com.xr.springboot_1_lianxi.model.User;
import com.xr.springboot_1_lianxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> queryList() {
        return userMapper.queryList();
    }
}
