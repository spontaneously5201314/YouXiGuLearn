package com.pat.basic;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Description 读入一个自然数n，计算其各位数字之和，用汉语拼音写出和的每一位数字。
 *              输入格式：每个测试输入包含1个测试用例，即给出自然数n的值。这里保证n小于10^100。
 *              输出格式：在一行内输出n的各位数字之和的每一位，拼音数字间有1 空格，但一行中最后一个拼音数字后没有空格。 输入样例：
 *              1234567890987654321123456789 输出样例： yi san wu
 * @author Spontaneously
 * @time 2016年1月19日 上午11:40:26
 */
public class Number1002 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BigInteger num = scanner.nextBigInteger();
		int returnSum = returnSum(num);
		System.out.println(read(returnSum));
	}

	private static int returnSum(BigInteger num) {
		BigInteger sum = BigInteger.ZERO;
		while (num != BigInteger.ZERO) {
			BigInteger[] remainder = num.divideAndRemainder(BigInteger.TEN);
			sum = remainder[1].add(sum);
			num = remainder[0];
		}
		return sum.intValue();
	}
	
	private static String read(int sum){
		StringBuffer sb = new StringBuffer();
		String string = String.valueOf(sum);
		char[] charArray = string.toCharArray();
		for(int i = 0; i < charArray.length - 1; i++){
			sb.append(readNumber(charArray[i]) + " ");
		}
		sb.append(readNumber(charArray[charArray.length - 1]));
		return sb.toString();
	}
	
	private static String readNumber(char i){
		switch(i){
		case '1':
			return "yi";
		case '2':
			return "er";
		case '3':
			return "san";
		case '4':
			return "si";
		case '5':
			return "wu";
		case '6':
			return "liu";
		case '7':
			return "qi";
		case '8':
			return "ba";
		case '9':
			return "jiu";
		default:
			return "ling";
		}
	}
}
