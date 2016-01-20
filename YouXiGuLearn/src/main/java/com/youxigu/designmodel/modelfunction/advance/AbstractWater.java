package com.youxigu.designmodel.modelfunction.advance;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:51:41
*/
public abstract class AbstractWater {

	public final void makeDrink(){
		blow();
		addMaterial();
		poulCup();
		addMoreMaterial();
	}
	
	protected void blow(){
		System.out.println("blow water!");
	}
	
	protected void poulCup(){
		System.out.println("poul cup!");
	}
	
	protected abstract void addMaterial();
	
	protected abstract void addMoreMaterial();
}
