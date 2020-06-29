package com.vinlen.zxc.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//此注解可以用在类上
@Target({ElementType.TYPE})
//jvm加载class文件之后，注解仍然存在
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
	String value();
}
