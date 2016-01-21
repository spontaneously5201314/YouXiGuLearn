package com.youxigu.designpatterns.modelfunction.advance;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:56:30
*/
public class Coffee extends AbstractWater {

	@Override
	protected void addMaterial() {
		System.out.println("add coffee!");
	}

	@Override
	protected void addMoreMaterial() {
		System.out.println("add milke!");
	}

}
