package com.youxigu.jvm.managementapi;

import java.lang.management.ClassLoadingMXBean;
import java.lang.management.ManagementFactory;

import javax.management.ObjectName;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月19日 下午3:07:48
*/
public class ManagementTestOne {

	public static void main(String[] args) {
		ClassLoadingMXBean classLoadingMXBean = ManagementFactory.getClassLoadingMXBean();
		int count = classLoadingMXBean.getLoadedClassCount();
		System.out.println(count);
		ObjectName name = classLoadingMXBean.getObjectName();
		System.out.println(name);
	}
}
