package com.xr.springboot_1_lianxi.controller;

import com.xr.springboot_1_lianxi.model.User;
import com.xr.springboot_1_lianxi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/select",method = RequestMethod.GET)
    @ResponseBody
    public ModelAndView test(){
        List<User> userList = userService.queryList();
        ModelAndView mv=new ModelAndView();
        mv.addObject("users",userList);
        mv.setViewName("list");
        return mv;
    }

    @RequestMapping(value = "/insert",method = RequestMethod.POST)
    public String test1(User user){
        int i = userService.addUsere(user);
        if(i>0){
            return "true";
        }
        return "false";
    }

    @RequestMapping("gotoAdd")
    public ModelAndView gotoadd(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("add");
        return mv;
    }
}
