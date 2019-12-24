package com.xr.springboot_1_lianxi.dao;

import com.xr.springboot_1_lianxi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    List<User> queryList();
}
