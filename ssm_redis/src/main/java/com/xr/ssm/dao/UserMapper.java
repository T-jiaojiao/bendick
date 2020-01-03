package com.xr.ssm.dao;

import com.xr.ssm.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> queryUser();
}
