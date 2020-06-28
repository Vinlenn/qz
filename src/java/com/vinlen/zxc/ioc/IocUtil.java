package com.vinlen.zxc.ioc;

import com.vinlen.zxc.ioc.annotationLoader.Inject;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Map.Entry;

public class IocUtil {
    public static void inject() {
        Map<Class<?>, Object> map = IocLoader.applicationContext;
        try {
            //拆分容器
            for (Entry<Class<?>, Object> entry : map.entrySet()) {
                //key是类型
                Class<?> clazz = entry.getKey();
                //value是key对应的实例
                Object obj = entry.getValue();
                //获取类型的所有字段
                Field[] fields = clazz.getDeclaredFields();
                //如果某个字段标记了inject，则获取该字段的类型，从容器里按照类型取出对应的实例注入进属性
                for (Field field : fields) {
                    if (field.isAnnotationPresent(Inject.class)) {
                    	//总体思路，获取字段的类型，从bean容器里获取再赋值
                        Class<?> fieldClazz = field.getType();
                        field.setAccessible(true);
                        Object fieldObj = map.get(fieldClazz);
                        field.set(obj, fieldObj);
                        String string = obj.getClass().toString();
                        string=string.substring(string.lastIndexOf(".")+1)+".class";
                        System.out.println(string+"类注入成功");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}