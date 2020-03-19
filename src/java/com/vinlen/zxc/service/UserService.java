package com.vinlen.zxc.service;



import com.vinlen.zxc.bean.User;
import com.vinlen.zxc.ioc.annotationLoader.Component;

@Component
public class UserService {
    public User getUser(){
        return new User("张三",30);
    }
}
