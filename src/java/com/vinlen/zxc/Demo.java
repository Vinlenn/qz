package com.vinlen.zxc;

import com.vinlen.zxc.controller.UserController;
import com.vinlen.zxc.ioc.annotationLoader.AnnoLoader;
import com.vinlen.zxc.ioc.comboLoader.ComboLoader;


public class Demo {
	public static void main(String[] args) {
		new ComboLoader("ioc","com.vinlen.zxc");
		UserController userController = (UserController) AnnoLoader.applicationContext.get(UserController.class);
		userController.say();
	}
}
