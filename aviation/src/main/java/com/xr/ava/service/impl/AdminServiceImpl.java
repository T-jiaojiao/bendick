package com.xr.ava.service.impl;

import com.xr.ava.dao.AdminMapper;
import com.xr.ava.model.Admin;
import com.xr.ava.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;
    @Override
    public Admin dengLu(Admin admin) {
        return adminMapper.dengLu(admin);
    }

    @Override
    public List<Map<String, Object>> queryAdminandRoleName() {
        return adminMapper.queryAdminandRoleName();
    }

    @Override
    public List<Map<String, Object>> findIDAdminRM(Integer aid) {
        return adminMapper.findIDAdminRM(aid);
    }


}
