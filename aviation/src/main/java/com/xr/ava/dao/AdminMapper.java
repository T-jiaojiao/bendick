package com.xr.ava.dao;

import com.xr.ava.model.Admin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface AdminMapper {

    Admin dengLu(Admin admin);

    List<Map<String,Object>> queryAdminandRoleName();

    List<Map<String,Object>> findIDAdminRM(Integer aid);


}
