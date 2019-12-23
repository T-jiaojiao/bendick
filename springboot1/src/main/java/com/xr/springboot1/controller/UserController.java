package com.xr.springboot1.controller;

import com.xr.springboot1.model.User;
import com.xr.springboot1.service.UserService;
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

    @RequestMapping(value = "listquery",method = RequestMethod.GET)
    public ModelAndView queryUser(){
        List<User> userList = userService.query();
        for (User user : userList) {
            System.out.println(user);
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("users",userList);

        mv.setViewName("success");
        return mv;
    }
}
