package com.youxigu.designpatterns.modelfunction.advance;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:57:10
*/
public class AbstractWaterTest {

	public static void main(String[] args) {
		AbstractWater aw1 = new Coffee();
		aw1.makeDrink();
		System.out.println("++++++++++++++++");
		AbstractWater aw2 = new Tea();
		aw2.makeDrink();
	}
}
