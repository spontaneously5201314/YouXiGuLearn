package com.pat.basic;
/**
* @Description 
* 读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
* 输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10^100。
* 输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。
* 输入样例：
* 1234567890987654321123456789
* 输出样例：
* yi san wu
* @author Spontaneously
* @time 2016年1月19日 上午11:40:26
*/
public class Number1002 {

	public static void main(String[] args) {
		
	}
	
	private static String returnSum(Long num){
		StringBuffer sb = new StringBuffer();
		long sum = 0;
		while(num != 0){
			sum += num%10;
			num = num >> 1;
		}
		return sb.toString();
	}
}
