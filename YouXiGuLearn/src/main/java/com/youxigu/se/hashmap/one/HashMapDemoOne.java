package com.youxigu.se.hashmap.one;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

/**
* @Description: 
* @author myg
* @time 2015年12月18日 上午11:39:25
*/
public class HashMapDemoOne {

	public static void main(String[] args) {
		HashMap<Integer,String> map = new HashMap<Integer,String>(256);
		map.put(1, "one");
		map.put(2, "two");
		Set<Entry<Integer,String>> set = map.entrySet();
		for (Entry<Integer, String> entry : set) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
	}
}
