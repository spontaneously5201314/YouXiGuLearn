package com.youxigu.se.exception;

import java.util.Collection;
import java.util.HashMap;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 下午6:16:22
*/
public class ExceptionTest1 {

	public static void main(String[] args) {
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		try {
			map.put(1, 1);
			map.put(2, 2);
			map.put(3, 3);
			map.put(4, 4);
			map.put(5, 5);
			
			Collection<Integer> collection = map.values();
			throw new Exception();
			
		} catch (Exception e) {
			for (StackTraceElement ste : e.getStackTrace()) {
				System.out.println(ste);
			}
		}
		
	}
}
