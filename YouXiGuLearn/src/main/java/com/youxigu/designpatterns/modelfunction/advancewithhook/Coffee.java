package com.youxigu.designpatterns.modelfunction.advancewithhook;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午6:05:08
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
	
	@Override
	protected boolean askCustomer(){
		return true;
	}

}
