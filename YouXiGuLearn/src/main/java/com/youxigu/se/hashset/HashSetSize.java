package com.youxigu.se.hashset;
/**
* @Description: 
* @author myg
* @time 2015年12月22日 下午3:55:19
*/
public class HashSetSize {

	public static void main(String[] args) {
		int i = Math.max((int) (16/.75f) + 1, 16);
		System.out.println(i);
	}
}
