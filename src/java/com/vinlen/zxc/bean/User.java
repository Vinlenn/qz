package com.vinlen.zxc.bean;

//一个普通的poji类
public class User {
	private String userName;
	private Integer age;

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public User() {
	}

	public User(String userName, Integer age) {
		this.userName = userName;
		this.age = age;
	}

	@Override
	public String toString() {
		return "User{" +
				"userName='" + userName + '\'' +
				", age=" + age +
				'}';
	}
}
