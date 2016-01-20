package com.youxigu.se.classloader;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月19日 下午6:31:41
*/
public class ClassLoaderTestOne {

	public static void main(String[] args) {
		ClassLoader loader = ClassLoaderTestOne.class.getClassLoader();
		while(loader != null){
			System.out.println(loader.getClass().getName());
			loader = loader.getParent();
		}
//		System.out.println(loader);
		System.out.println(System.getProperty("java.vm.name"));
		System.out.println(System.getProperty("java.vm.info"));
	}
}
