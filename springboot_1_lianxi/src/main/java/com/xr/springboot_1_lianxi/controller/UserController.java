package com.xr.springboot_1_lianxi.controller;

import com.xr.springboot_1_lianxi.model.User;
import com.xr.springboot_1_lianxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    public ModelAndView test(){
        List<User> userList = userService.queryList();
        for (User s : userList) {
            System.out.println(s);
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("users",userList);
        mv.setViewName("thymeleaf");
        return mv;
    }
}
