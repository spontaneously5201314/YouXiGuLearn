package com.youxigu.designpatterns.modelfunction.advance;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:58:05
*/
public class Tea extends AbstractWater {

	@Override
	protected void addMaterial() {
		System.out.println("add tea!");
	}

	@Override
	protected void addMoreMaterial() {
		System.out.println("add more tea!");
	}

}
