package com.xr.ssm.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xr.ssm.pojo.User;
import com.xr.ssm.service.UserService;
import com.xr.ssm.util.RedisTemplateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private RedisTemplateUtil redisTemplateUtil;

    @Autowired
    private UserService userService;

    @RequestMapping("/look")
    @ResponseBody
    public ModelAndView query(){
        System.out.println("W-weijieSB");
        List<User> users = userService.queryUser();
        for (User user : users) {
            System.out.println(user);
        }
        ModelAndView mv=new ModelAndView();
        mv.addObject("user",users);
        mv.setViewName("/querylist.jsp");
        return mv;
    }

    @RequestMapping("/select")
    @ResponseBody
    public String selectUser(Model model){
        //jackson包
        System.out.println("进入1..........................");
        ObjectMapper om=new ObjectMapper();
        //虚拟机获取的值就是（get key里的路径
        String key="com.xr.ssm.controller.UserController.selectUser";
        //1.先从缓存中获取
        Object value = redisTemplateUtil.getString(key);
        System.out.println("缓存中取出..........................!!!!!!"+value);
        List<User> users=null;
        if(value==null){
            System.out.println("congshuJukuduQu...");
            try {
                //2.从数据库获取
                users = userService.queryUser();
                //将查询出来的集合转换成JSON格式
                String s = om.writeValueAsString(users);
                //3.将数据存入数据
                redisTemplateUtil.setString(key,s);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println("conghuancunduQu..........");
            try {
                //将缓存中获得的数据转换成用户需要的类型，json字符串格式
                om.readValue(value.toString(),new TypeReference<List<User>>(){});
            }catch (IOException e){
                e.printStackTrace();
            }
        }
        model.addAttribute("users",users);
        return "querylist.jsp";
    }
}
