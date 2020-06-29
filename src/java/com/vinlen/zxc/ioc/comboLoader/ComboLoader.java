package com.vinlen.zxc.ioc.comboLoader;

import com.vinlen.zxc.ioc.IocLoader;
import com.vinlen.zxc.ioc.annotationLoader.AnnoLoader;
import com.vinlen.zxc.ioc.jsonLoader.JsonLoader;

/**
 * 组合加载器，从json配置文件或者根据注解进行注入
 * 如果不需要使用从json读取，直接使用注解加载器
 */

public class ComboLoader extends IocLoader {

	//注解加载器需要查找是否使用注解的文件夹
	private String annoLoaderPath;

	//json加载器需要查找是否使用注解的文件夹
	private String jsonLoaderPath;

	//目前只支持两种加载器，使用了复合加载器，那就要两个加载器一起使用了
	//先使用json加载bean交给容器但不注入。 使用注解加载才会注入
	public ComboLoader(String jsonLoaderPath, String annoLoaderPath) {
		this.jsonLoaderPath = jsonLoaderPath;
		this.annoLoaderPath = annoLoaderPath;
		try {
			new JsonLoader(jsonLoaderPath);
			new AnnoLoader(annoLoaderPath);
		} catch (Exception e) {
			System.out.println("load bean fail!");
		}
	}
}
