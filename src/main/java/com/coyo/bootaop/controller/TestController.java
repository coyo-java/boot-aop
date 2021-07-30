package com.coyo.bootaop.controller;


import com.coyo.bootaop.entity.User;
import com.coyo.bootaop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {

    @Autowired
    private UserService userService;

    @RequestMapping("/test")
    @ResponseBody
    public User test1(HttpServletRequest request){
        request.getServletContext().getRealPath("/");
        return userService.test();
    }
}
