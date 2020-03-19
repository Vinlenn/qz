package com.vinlen.zxc;

import com.vinlen.zxc.controller.AnimalController;
import com.vinlen.zxc.controller.UserController;
import com.vinlen.zxc.ioc.annotationLoader.AnnoLoader;

public class Client {
    public static void main(String[] args) throws Exception {
        //启动注解加载器
        new AnnoLoader("com.vinlen.zxc");
        UserController userController = (UserController) AnnoLoader.applicationContext.get(UserController.class);
        userController.getUser();
        AnimalController animalController=(AnimalController)AnnoLoader.applicationContext.get(AnimalController.class);
        animalController.getAnimal();
    }
}