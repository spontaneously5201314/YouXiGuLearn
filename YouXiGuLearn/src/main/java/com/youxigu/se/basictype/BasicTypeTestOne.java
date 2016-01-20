package com.youxigu.se.basictype;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月19日 下午5:55:43
*/
public class BasicTypeTestOne {

	public static void main(String[] args) {
//		int a = 3;
//		int b = 3;
//		System.out.println(a == b);
//		b = 4;
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(a == b);
		String str1 = "abc";//这个是放在栈中的
		String str2 = new String("abc");//这个是放在堆中的
		System.out.println(str1 == str2);
	}
}
