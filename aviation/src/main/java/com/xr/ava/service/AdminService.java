package com.xr.ava.service;

import com.xr.ava.model.Admin;

import java.util.List;
import java.util.Map;

public interface AdminService {
    Admin dengLu(Admin admin);

    List<Map<String,Object>> queryAdminandRoleName();

    List<Map<String,Object>> findIDAdminRM(Integer aid);
}
