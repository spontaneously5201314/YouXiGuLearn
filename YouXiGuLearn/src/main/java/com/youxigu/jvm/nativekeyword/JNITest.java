package com.youxigu.jvm.nativekeyword;
/**
* @Description native关键字学习 
* @author Spontaneously
* @time 2016年1月18日 上午11:11:51
*/
public class JNITest {

	/**
	 * 建立一个没有返回值没有参数的方法，该方法值在DLL方法类打印一条语句
	 */
	public native void test();
	
}
