package com.vinlen.qz.ioc;

import com.vinlen.qz.Util.IocFactory;

public abstract class IocLoader {
	//map就是容器！！！ map的key就bean的类型，value是bean的实例
	protected static final IocFactory applicationContext = new IocFactory();

	public static IocFactory getIoc() {
		return applicationContext;
	}

}
