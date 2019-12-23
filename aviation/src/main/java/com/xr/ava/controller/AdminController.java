package com.xr.ava.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.xr.ava.model.Admin;
import com.xr.ava.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/Admin")
public class AdminController  {
    @Autowired
    private AdminService adminService;
    @Autowired
    private  GuoNeiFlay guoNeiFlay;

    @RequestMapping(value = "/ajaxdenglu",method = RequestMethod.GET)
    @ResponseBody
    public String regist(Admin admin, HttpSession session){
        System.out.println("1234");
        Admin admins = adminService.dengLu(admin);
        System.out.println("----"+admins);
        if(admins==null){
            return "false";
        }else{
            session.setAttribute("admins",admins);
            return "true";
        }
    }


    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public String querylist(){
        List<Map<String, Object>> mapList = adminService.queryAdminandRoleName();
        String s = JSONArray.toJSONStringWithDateFormat(mapList,"yyyy-MM-dd");
        System.out.println(s);
        return s;
    }


    @RequestMapping(value = "/findByID",method = RequestMethod.GET)
    @ResponseBody
    public String findIDUpdate(Integer aid){
        List<Map<String, Object>> idAdminRM = adminService.findIDAdminRM(aid);
        for (Map<String, Object> map : idAdminRM) {
            for(String s:map.keySet()){
                System.out.println(s+"----------------"+map.get(s)+" ");
            }
        }
        String s = JSONArray.toJSONString(idAdminRM);
        return s;
    }
}
