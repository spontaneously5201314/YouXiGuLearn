package com.youxigu.se.serializable;

import java.io.Serializable;

/**
* @Description: 
* @author myg
* @time 2015年11月30日 下午6:27:05
*/
public class Person implements Serializable {

	private String name;
	
	private int age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

}
