package com.vinlen.zxc.bean;

import com.vinlen.zxc.aop.After;
import com.vinlen.zxc.aop.Aspect;
import com.vinlen.zxc.ioc.annotationLoader.Component;

@Component
@Aspect(value = "com.vinlen.zxc.proxy.Demo")
public class Dog implements Animal {

	@After
	public void say(){
		System.out.println("原本的动作");
	}
}
