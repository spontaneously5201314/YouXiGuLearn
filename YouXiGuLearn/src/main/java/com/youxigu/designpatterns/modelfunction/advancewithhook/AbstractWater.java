package com.youxigu.designpatterns.modelfunction.advancewithhook;
/**
* @Description 
* @author Spontaneously
* @time 2016年1月20日 下午5:59:57
*/
public abstract class AbstractWater {

	public final void makeDrink(){
		blow();
		addMaterial();
		addCup();
		if(askCustomer()){
			addMoreMaterial();
		}
	}
	
	protected void blow(){
		System.out.println("blow water!");
	}
	
	protected void addCup(){
		System.out.println("add cup!");
	}
	
	protected abstract void addMaterial();
	
	protected abstract void addMoreMaterial();
	
	protected abstract boolean askCustomer();
}
