package com.youxigu.designpatterns.modelfunction.basic;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:39:54
*/
public class Coffee {

	public static void main(String[] args) {
		makeCoffee();
	}
	
	public static void makeCoffee(){
		blow();
		addCoffee();
		poulCup();
		addMilke();
	}
	
	private static void blow(){
		System.out.println("blow water!");
	}
	
	private static void addCoffee(){
		System.out.println("add coffee!");
	}
	
	private static void poulCup(){
		System.out.println("poul cup!");
	}
	
	private static void addMilke(){
		System.out.println("add milke");
	}
}
