package com.youxigu.se.help;

import java.util.Arrays;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月19日 上午10:34:33
*/
public class HelpTest {

	public static void main(String[] args) {
		String[] destStrings = { "1", "2", "3", "4", "5", "a", "b", "c", "d", "e", "1+2+3", "2+3", "a+b" };
		System.out.println(destStrings.toString());
//		System.out.println(destStrings.to);
		System.out.println(Arrays.toString(destStrings));
	}
}
