package com.vinlen.qz.ioc;


import com.vinlen.qz.aop.JoinPoint;
import com.vinlen.qz.aop.Aspect;
import com.vinlen.qz.ioc.annotationLoader.Inject;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

public class IocUtil {
	private static Map<Class<?>, Object> map = IocLoader.applicationContext;
	public static void inject() {
		startAop();
		startInject();
	}

	private static void startAop(){
		try {
			//思路：如果某个类的某个方法选择了代理  直接生成字节码
			for (Entry<Class<?>, Object> entry : map.entrySet()) {
				//map中的类型
				Class<?> clazz = entry.getKey();
				//map中的实例
				Object obj = entry.getValue();
				if (clazz.isAnnotationPresent(Aspect.class)) {
					Aspect as = clazz.getAnnotation(Aspect.class);
					for (Method declaredMethod : clazz.getDeclaredMethods()) {
						//获取标记的注解类
						if (declaredMethod.isAnnotationPresent(JoinPoint.class)) {
							//如果方法标记了JoinPoint 则将此方法代理
							Class<?> aClass = Class.forName(as.value());
							Method[] methods = aClass.getMethods();
							Enhancer enhancer = new Enhancer();
							enhancer.setSuperclass(clazz);
							enhancer.setCallback((Callback) aClass.newInstance());
							//将代理的类放进容器覆盖之前的Object
							map.put(clazz, enhancer.create());
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void startInject(){
		try {
			//拆分容器
			for (Entry<Class<?>, Object> entry : map.entrySet()) {
				//key是类型
				Class<?> clazz = entry.getKey();
				//value是key对应的实例
				Object obj = entry.getValue();
				//如果某个字段标记了inject，则获取该字段的类型，从容器里按照类型取出对应的实例注入进属性
				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					if (field.isAnnotationPresent(Inject.class)) {
						//总体思路，获取字段的类型，从bean容器里获取再赋值
						Class<?> fieldClazz = field.getType();
						field.setAccessible(true);
						Object fieldObj = map.get(fieldClazz);
						field.set(obj, fieldObj);
						String string = obj.getClass().toString();
						string = string.substring(string.lastIndexOf(".") + 1) + ".class";
						System.out.println(string + " inject success!");
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//使用jdk代理 已废弃
	private static void startAopByJdk(){
		try {
			//思路：如果某个类的某个方法选择了代理  使用反射创建代理对象放入map覆盖
			for (Entry<Class<?>, Object> entry : map.entrySet()) {
				//map中的类型
				Class<?> clazz = entry.getKey();
				//map中的实例
				Object obj = entry.getValue();
				if (clazz.isAnnotationPresent(Aspect.class)) {
					Aspect as = clazz.getAnnotation(Aspect.class);
					for (Method declaredMethod : clazz.getDeclaredMethods()) {
						//获取标记的注解类
						if (declaredMethod.isAnnotationPresent(JoinPoint.class)) {
							//如果方法标记了After 则将此方法代理
							Class<?> aClass = Class.forName(as.value());
							Method[] methods = aClass.getMethods();
							Method bind = aClass.getMethod("bind", Object.class);
							Object invoke = bind.invoke(map.get(aClass), obj);
							//将代理的类放进容器覆盖之前的Object
							map.put(clazz, invoke);
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}