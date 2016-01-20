package com.youxigu.se.type;

import com.youxigu.se.annotation.MyAnnotationOne;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月14日 上午9:51:33
*/
public class VoidTest {

	@MyAnnotationOne
	public static void main(String[] args) {
		if(VoidTest.class.isAnnotationPresent(MyAnnotationOne.class)){
//			System.out.println(VoidTest.class.getAnnotation(MyAnnotationOne.class));
		}
	}
}
