package com.vinlen.zxc.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//扫描ioc容器，找到含有Aspect的注解的类，为其创造代理类对象，并替代原来的bean
//作用在标题上
@Target(ElementType.TYPE)
//运行时注解依然存在
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
}
