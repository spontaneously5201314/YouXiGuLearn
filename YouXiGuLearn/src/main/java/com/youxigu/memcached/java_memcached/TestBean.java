package com.youxigu.memcached.java_memcached;

import java.io.Serializable;

/**
* @Description: 
* @author myg
* @time 2015年11月30日 下午2:59:42
*/
public class TestBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6879906896355941318L;
	private String name;
	private Integer age;
	
	
	public TestBean() {
		super();
	}
	public TestBean(String name, Integer age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "TestBean [name=" + name + ", age=" + age + "]";
	}
	
}
