package com.vinlen.zxc.Util;

import java.util.Collection;
import java.util.LinkedHashMap;

public class IocFactory extends LinkedHashMap<Class<?>, Object> {
	//从容器里获取对象时自动将Object转为对应类型
	//如果添加了aop  可能无法将代理对象转换为其他类型
	@SuppressWarnings("unchecked")
	public <T> T get2Class(Class<T> type) {
		return (T) get(type);
	}
}
