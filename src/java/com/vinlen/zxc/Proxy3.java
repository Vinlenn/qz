package com.vinlen.zxc;

import com.vinlen.zxc.aop.CglibProxy;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class Proxy3 extends CglibProxy {
	@Override
	public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
		System.out.println("增强");
		return methodProxy.invokeSuper(o,objects);
	}
}
