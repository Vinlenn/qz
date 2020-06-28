package com.vinlen.zxc.ioc.annotationLoader;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//此注解用在变量上
@Target({ElementType.FIELD})
//jvm加载class文件之后，仍然存在
@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}
