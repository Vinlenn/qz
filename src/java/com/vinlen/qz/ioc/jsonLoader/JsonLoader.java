package com.vinlen.qz.ioc.jsonLoader;

import com.alibaba.fastjson.JSONObject;
import com.vinlen.qz.ioc.IocLoader;
import org.apache.commons.io.FileUtils;

import java.io.File;

import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.Map;

//从json配置文件加载bean
public class JsonLoader extends IocLoader {

	public JsonLoader(String path) {
		try {
			initBean(path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void initBean(String packageName) throws Exception {
		Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
		while (urls.hasMoreElements()) {
			System.out.println("start JsonLoader!");
			addClassByJson(urls.nextElement().getPath(), packageName);
		}
		System.out.println("complete JsonLoader!");
	}

	private static void addClassByJson(String filePath, String packageName)  {
		try {
			//返回的是个文件夹目录 数组
			File[] files = getClassFile(filePath);
			if (files != null) {
				for (File f : files) {
					String s = FileUtils.readFileToString(f, "UTF-8");
					JSONObject maps = JSONObject.parseObject(s);
					if (maps != null) {
						//取出按钮权限的数据
						Class<?> aClass = Class.forName((String) maps.get("class"));
						//创建实例
						Object obj = aClass.newInstance();
						Map field = (Map) maps.get("filed");
						Field[] declaredFields = aClass.getDeclaredFields();
						for (Field declaredField : declaredFields) {
							declaredField.setAccessible(true);
							Object o = field.get(declaredField.getName());
							declaredField.set(obj, o);
						}
						applicationContext.put(aClass, obj);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private static File[] getClassFile(String filePath) {
		return new File(filePath).listFiles(file -> {
			//必须满足条件才会放到数组里
			//必须是文件。 q且是.js结尾
			return file.isFile() && file.getName().endsWith(".json");
		});
	}

}
