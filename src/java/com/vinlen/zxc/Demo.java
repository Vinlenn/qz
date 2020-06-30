package com.vinlen.zxc;


import com.vinlen.zxc.Util.IocFactory;
import com.vinlen.zxc.bean.Dog;
import com.vinlen.zxc.controller.UserController;
import com.vinlen.zxc.ioc.IocLoader;
import com.vinlen.zxc.ioc.comboLoader.ComboLoader;


public class Demo {
	public static void main(String[] args) {
		new ComboLoader("ioc", "com.vinlen.zxc");
		IocFactory ioc = IocLoader.getIoc();
		UserController aClass = ioc.get2Class(UserController.class);
		aClass.say();
		Dog dog = ioc.get2Class(Dog.class);
		dog.say();
	}
}
