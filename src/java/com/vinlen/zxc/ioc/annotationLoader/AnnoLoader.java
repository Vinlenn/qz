package com.vinlen.zxc.ioc.annotationLoader;


import com.vinlen.zxc.ioc.IocLoader;
import com.vinlen.zxc.ioc.IocUtil;

import java.io.File;
import java.net.URL;
import java.util.Enumeration;


/*
 * 添加了@Component注解的类会被标记为bean类 会通过反射创建一个实例存放在map里
 *添加了@Inject的字段默认为需要注入的字段，类自身必须在容器里，通过反射获取所有字段的数组
 * 遍历数组 如果某个字段标记了inject 则获取字段的属性 根据属性从map里获取值注入
 *
 *
 *
 *
 * */
public class AnnoLoader extends IocLoader {
     private String packageName;

    public AnnoLoader(String packageName) {
        this.packageName = packageName;
        try {
            initBean(packageName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void initBean(String packageName) throws Exception {

        //获取当前ClassPath的绝对URI路径   使用"/"替换"\\."使用枚举
        Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packageName.replaceAll("\\.", "/"));
        //当前路径下有其他文件，调用方法
        while (urls.hasMoreElements()) {
            System.out.println("开始执行注解加载器");
            addClassByAnnotation(urls.nextElement().getPath(), packageName);
        }
        System.out.println("注解bean加载完成");
        //IOC实现， 自动注入
        System.out.println("开始执行bean注入");
        IocUtil.inject();
        System.out.println("bean注入完成");
    }
    //获取指定包路径下实现 Component主键Bean的实例
    private static void addClassByAnnotation(String filePath, String packageName) {
        try {
            //返回的是个文件夹目录 数组
            File[] files = getClassFile(filePath);
            if (files != null) {
                for (File f : files) {
                    //得到名称
                    String fileName = f.getName();
                    //要么是.class  要么就是文件夹
                    if (f.isFile()) {
                        //是.class的话开启反射 看看是不是标记了注解，是注解的话就加入map集合
                        Class<?> clazz = Class.forName(packageName + "." + fileName.substring(0,fileName.lastIndexOf(".")));
                        if(clazz.isAnnotationPresent(Component.class)) {
                            applicationContext.put(clazz, clazz.newInstance());
                            String classPath = clazz.toString();
                            String className = classPath.substring(classPath.lastIndexOf(".") + 1)+".class";
                            System.out.println("加载"+className+"   bean成功");
                        }
                    }//不是.class，那就是文件夹，传回去继续找
                    else {
                        addClassByAnnotation(f.getPath(), packageName + "." + fileName);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取该路径下所遇的class文件和目录
    private static File[] getClassFile(String filePath) {
        return new File(filePath).listFiles(file -> {
            //必须满足条件才会放到数组里
            //必须是文件。 要么是.class  要么是文件夹
            return file.isFile() && file.getName().endsWith(".class") || file.isDirectory();
        });
    }
}
