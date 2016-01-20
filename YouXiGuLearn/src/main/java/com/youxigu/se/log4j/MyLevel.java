package com.youxigu.se.log4j;

import org.apache.log4j.Level;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月13日 上午10:33:24
*/
public class MyLevel extends Level {
	
	private static final int MYLEVEL = 0;
	public static final Level level = new MyLevel(MYLEVEL, "MYLEVEL", 100);

	protected MyLevel(int level, String levelStr, int syslogEquivalent) {
		super(level, levelStr, syslogEquivalent);
		// TODO Auto-generated constructor stub
	}

}
