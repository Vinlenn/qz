package com.vinlen.zxc.bean;

import com.vinlen.zxc.aop.JoinPoint;
import com.vinlen.zxc.aop.Aspect;
import com.vinlen.zxc.ioc.annotationLoader.Component;

@Component
@Aspect(value = "com.vinlen.zxc.Proxy2")
public class Dog implements Animal {

	@JoinPoint
	public void say(String name){
		System.out.println("原本的动作"+name);
	}
}
