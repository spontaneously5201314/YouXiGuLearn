package com.youxigu.designpatterns.modelfunction.basic;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:49:21
*/
public class Tea {

	public static void main(String[] args) {
		makeTea();
	}
	
	public static void makeTea(){
		blow();
		addTea();
		poulCup();
		addMoreTea();
	}
	
	private static void blow(){
		System.out.println("blow water!");
	}
	
	private static void addTea(){
		System.out.println("add tea!");
	}
	
	private static void poulCup(){
		System.out.println("poul cup!");
	}
	
	private static void addMoreTea(){
		System.out.println("add more tea");
	}
}
