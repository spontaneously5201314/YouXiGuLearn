package com.youxigu.se.help;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * @Description 现在有很多个元素（设40个），我有几种固定组合（比如“1+2+36“，但是上限为5个）。
 *              现在传入一个数组（数组内元素个数，号码均随机），如何能快速匹配到所有组合？ 目标库{1,2,3,4,5，a,b,c,d,e}
 *              后有固定组合{1+2+3,2+3,a+b} 即目标库为{1,2,3,4,5，a,b,c,d,e，1+2+3,2+3,a+b}
 *              先传入参数{1,2,3，c,d} 返回{1+2+3,2+3，c,d}
 * @author Spontaneously
 * @time 2016年1月15日 下午5:44:49
 */
public class HelpTwo {
	public static void main(String[] args) {
		String[] destStrings = { "1", "2", "3", "4", "5", "a", "b", "c", "d", "e", "1+2+3", "2+3", "a+b" };//[1, 2, 3, 4, 5, a, b, c, d, e, 1+2+3, 2+3, a+b]
		String[] paramStrings = { "1", "2", "3", "c", "d" };//[1, 2, 3, c, d]
		ArrayList<String> result = new ArrayList<String>();
		Map<String,Integer> singleMap = new HashMap<String,Integer>();//{3=0, 2=0, d=0, 1=0, e=0, b=0, c=0, 5=0, a=0, 4=0}
		Map<String,Integer> longMap = new HashMap<String,Integer>();//{2+3=0, a+b=0, 1+2+3=0}
		for (String destString : destStrings) {
			if(destString.length() == 1){
				if(!singleMap.containsKey(destString))
					singleMap.put(destString, 0);
			}else{
				if(!longMap.containsKey(destString))
					longMap.put(destString, 0);
			}
		}
		Map<String,Integer> paramMap = new HashMap<String, Integer>();//{3=0, 2=0, d=0, 1=0, c=0}
		for (String paramString : paramStrings) {
			if(!paramMap.containsKey(paramString))
				paramMap.put(paramString, 0);
		}
		//下面开始遍历，先从longMap中遍历，在paramStrings中找组合，并改变
		Set<Entry<String, Integer>> longSet = longMap.entrySet();
		for (Entry<String, Integer> longEntry : longSet) {
			String[] longStringKey = longEntry.getKey().split("\\+");
			for (String longKey : longStringKey) {
				if(!Arrays.toString(paramStrings).contains(longKey)){
					resetToZero(paramMap);
					break;
				}else{
					paramMap.put(longKey, 1);
				}
			}
			if(valueOneSize(paramMap) == longStringKey.length){
				result.add(longEntry.getKey());
			}
		}
		//下面从给定的传入参数中遍历，找key对应的value是0的元素
		Set<Entry<String, Integer>> paramSet = paramMap.entrySet();
		for (Entry<String, Integer> paramEntry : paramSet) {
			if(paramEntry.getValue() == 0){
				result.add(paramEntry.getKey());
			}
		}
		System.out.println(result);
	}
	private static int valueOneSize(Map<String, Integer> map){
		int count = 0;
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			if(entry.getValue() == 1){
				count++;
			}
		}
		return count;
	}
	private static void  resetToZero(Map<String, Integer> map){
		Set<Entry<String, Integer>> set = map.entrySet();
		for (Entry<String, Integer> entry : set) {
			entry.setValue(0);
		}
	}
}
