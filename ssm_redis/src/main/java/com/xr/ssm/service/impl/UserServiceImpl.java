package com.xr.ssm.service.impl;

import com.xr.ssm.dao.UserMapper;
import com.xr.ssm.pojo.User;
import com.xr.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
    private UserMapper userMapper;

  @Override
  public List<User> queryUser() {
    return userMapper.queryUser();
  }
}
