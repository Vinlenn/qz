package com.vinlen.zxc;


import com.vinlen.zxc.aop.MyProxy;
import com.vinlen.zxc.ioc.annotationLoader.Component;

import java.lang.reflect.Method;

@Component
public class Proxy2 extends MyProxy {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("加强");
		//getObject()获取需要代理的类的实例 args表示方法的参数
		return method.invoke(getObject(), args);
	}
}

