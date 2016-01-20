package com.youxigu.se.collection;

import java.util.Collection;
import java.util.HashMap;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 下午4:58:03
*/
public class CollectionLearn {

	public static void main(String[] args) {
		
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		
		map.put(1, 1);
		map.put(2, 2);
		map.put(3, 3);
		map.put(4, 4);
		map.put(5, 5);
		
		Collection<Integer> collection = map.values();
//		System.out.println(collection);
		Object object = map.clone();
//		System.out.println(object);
//		System.out.println(object == map);
		String s1 = "abc";
		String s2 = new String("abc");
//		String s3 = ((Object)(s1)).clone();
		System.out.println(s1 == s2);
	}
}
