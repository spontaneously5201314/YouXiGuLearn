package com.youxigu.designpatterns.adapter;

public class SkyTool extends LandTool implements NeedTool {

	public void fly() {
		run();
	}
	
	public static void main(String[] args) {
		new SkyTool().fly();
	}

}
