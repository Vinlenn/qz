package com.vinlen.qz.aop;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/*
* 代理类抽象类，需要继承此类并重写接口
* 已使用cglib 代替此类
*
*
*
*/
public abstract class MyProxy implements InvocationHandler {

	private Object object;//被代理类

	public Object getObject() {
		return this.object;
	}


	//生成代理实例
	public Object bind(Object object) {
		this.object = object;
		return Proxy.newProxyInstance(object.getClass().getClassLoader(),
				object.getClass().getInterfaces(), this);
	}


}
