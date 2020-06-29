package com.vinlen.zxc.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyProxy implements InvocationHandler {

	private Object object;//被代理类

   //使用bind方法生成代理实例
	public Object bind(Object object){
		this.object=object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(object, args);
	}
}
