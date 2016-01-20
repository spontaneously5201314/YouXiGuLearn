package com.youxigu.jvm.securitymanager;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月13日 下午6:27:31
*/
public class SecurityManagerTestOne {

	public static void main(String[] args) throws FileNotFoundException {
//		System.setSecurityManager(null);
//		SecurityManager manager = new SecurityManager();
//		manager.checkRead("log4j.properties");
		System.out.println("SecurityManager:"+System.getSecurityManager());
		FileInputStream fis = new FileInputStream("log4j.properties");
		System.out.println(System.getProperty("file.encoding"));
	}
}
