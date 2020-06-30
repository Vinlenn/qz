package com.vinlen.zxc.aop;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
//自定义代理类需要继承此类并重写intercept方法
public  class CglibProxy implements MethodInterceptor {


	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		//可选前置增强

		return methodProxy.invokeSuper(o, objects);
		//可选后置增强
	}
}
