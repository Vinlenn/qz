package com.vinlen.zxc.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class myinvocationHandler implements InvocationHandler {
  private Object object;//被代理的类
  private Object invoke;//真正要执行的方法

  public void setObject(Object object){
      this.object=object;
  }
  /*
  *
  * */









    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return null;
    }
}
