package com.youxigu.jvm;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 上午10:52:50
*/
public class TestJvmServer {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		spend();
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
	private static void spend(){
		for(int i = 500000000; i > 0; i--){}
	}
}
