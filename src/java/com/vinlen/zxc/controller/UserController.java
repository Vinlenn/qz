package com.vinlen.zxc.controller;

import com.vinlen.zxc.bean.User;
import com.vinlen.zxc.ioc.annotationLoader.Component;
import com.vinlen.zxc.ioc.annotationLoader.Inject;
import com.vinlen.zxc.service.UserService;

//将此容器交给ioc 容器管理
@Component
public class UserController {
    //注入属性
    @Inject
    private UserService userService;
    public void getUser(){
        User user = userService.getUser();
        System.out.println(user);
    }
}
