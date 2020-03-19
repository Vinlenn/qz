package com.vinlen.zxc.ioc.jsonLoader;


import com.vinlen.zxc.ioc.IocLoader;

//从json配置文件加载bean
public class JsonLoader extends IocLoader {
   private String path;

    public JsonLoader(String path) {
        this.path = path;
        try{
            initBean(path);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void initBean(String path){
        //
    }

}
