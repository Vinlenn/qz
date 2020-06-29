package com.vinlen.zxc;

import com.vinlen.zxc.bean.Animal;
import com.vinlen.zxc.bean.Dog;
import com.vinlen.zxc.ioc.IocLoader;
import com.vinlen.zxc.ioc.comboLoader.ComboLoader;



public class Demo {
	public static void main(String[] args) {
	/*	new ComboLoader("ioc","com.vinlen.zxc");
		Map ioc = AnnoLoader.getIoc();
		UserController userController = (UserController) ioc.get(UserController.class);
		userController.say();*/
		new ComboLoader("ioc","com.vinlen.zxc");

		Animal animal=(Animal)IocLoader.applicationContext.get(Dog.class);
		animal.say();

	}

}
