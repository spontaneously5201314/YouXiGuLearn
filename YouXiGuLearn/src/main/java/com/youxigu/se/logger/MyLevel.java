package com.youxigu.se.logger;

import java.util.logging.Level;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月12日 下午5:36:09
*/
public class MyLevel extends Level {

	public static final Level SYSE = new MyLevel("SYSE", Level.FINEST.intValue() + 110);
	
	protected MyLevel(String name, int value) {
		super(name, value);
	}

}
