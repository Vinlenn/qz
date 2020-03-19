package com.vinlen.zxc.ioc.comboLoader;


import com.vinlen.zxc.ioc.IocLoader;
import com.vinlen.zxc.ioc.annotationLoader.AnnoLoader;
import com.vinlen.zxc.ioc.jsonLoader.JsonLoader;


public class ComboLoader extends IocLoader {
    //如果使用了复合加载器，则判断使用其他加载器
    private boolean userAnnoLoader;
    //如果不使用注解加载器，则为Null
    private String annoLoaderPath;

    private boolean userJsonLoader;
    //如果不使用json加载器，则为Null
    private String jsonLoaderPath;

    //目前只支持两种加载器，使用了复合加载器，那就要两个加载器一起使用了
    public ComboLoader(boolean userAnnoLoader, String annoLoaderPath, boolean userJsonLoader, String jsonLoaderPath) {
        this.userAnnoLoader = userAnnoLoader;
        this.annoLoaderPath = annoLoaderPath;
        this.userJsonLoader = userJsonLoader;
        this.jsonLoaderPath = jsonLoaderPath;

        try {
            new AnnoLoader(annoLoaderPath);
            new JsonLoader(jsonLoaderPath);


        } catch (Exception e) {
            System.out.println("加载bean失败");
        }


    }
}
