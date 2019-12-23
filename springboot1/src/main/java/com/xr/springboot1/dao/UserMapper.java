package com.xr.springboot1.dao;

import com.xr.springboot1.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> query();
}
