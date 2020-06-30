package com.vinlen.zxc.bean;

import com.vinlen.zxc.aop.JoinPoint;
import com.vinlen.zxc.aop.Aspect;
import com.vinlen.zxc.ioc.annotationLoader.Component;
import com.vinlen.zxc.ioc.annotationLoader.Inject;
import com.vinlen.zxc.service.UserService;

@Component
@Aspect(value = "com.vinlen.zxc.Proxy3")
public class Dog  {
	@JoinPoint
	public void say(){
		System.out.println("原本的动作");
	}
}
