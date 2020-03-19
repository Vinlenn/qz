package com.vinlen.zxc.bean;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract  class IocLoader {
    //map就是容器！！！ map的key就bean的类型，value是bean的实例
    public static final Map<Class<?>, Object> applicationContext = new ConcurrentHashMap<Class<?>, Object>();


}
