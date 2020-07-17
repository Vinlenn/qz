package com.vinlen.qz.Util;

import java.util.Collection;
import java.util.LinkedHashMap;

public class IocFactory extends LinkedHashMap<Class<?>, Object> {
	//从容器里获取对象时自动将Object转为对应类型
	//如果添加了aop  可能无法将代理对象转换为其他类型
	@SuppressWarnings("unchecked")
	public <T> T get2Class(Class<T> type) {
		return (T) get(type);
	}

	/**
	 * 设置一个字段，如果值为 null 则表示移除
	 *
	 * @param clazz
	 *            键
	 * @param v
	 *            值
	 */
	public void setOrRemove(Class<?> clazz, Object v) {
		if (null == v) {
			this.remove(clazz);
		} else {
			this.put(clazz, v);
		}
	}

}
