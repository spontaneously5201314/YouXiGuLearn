package com.youxigu.se.hashtable;

import java.util.HashMap;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月12日 下午2:27:21
*/
public class HashTableOne {
	
//	static Hashtable<Integer,Integer> ht = new Hashtable<Integer,Integer>();
	static HashMap<Integer,Integer> ht = new HashMap<Integer,Integer>();
	
	public static class Thread1 implements Runnable{
		int i = 0;
		public void run() {
			while(i < 100){
				ht.put(i, i);
				System.out.println("Thread1 has put key " + i + " and value " + i + "into this hashtable ht.");
				i++;
			}
		}
	}
	
	public static class Thread2 implements Runnable{

		int i = 0;
		public void run() {
			while(i < 100){
				ht.put(i, i);
				System.out.println("Thread2 has put key " + i + " and value " + i + "into this hashtable ht.");
				i++;
			}
		}
	}
	
	public static void main(String[] args) {
		Thread1 thread1 = new Thread1();
		Thread2 thread2 = new Thread2();
		thread1.run();
		thread2.run();
	}
}
