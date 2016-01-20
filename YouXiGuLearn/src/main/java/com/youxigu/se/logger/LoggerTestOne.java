package com.youxigu.se.logger;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月12日 下午4:00:15
*/
public class LoggerTestOne {

	public static void main(String[] args) {
//		Logger logger = Logger.getAnonymousLogger();
		Logger logger = Logger.getLogger("com.youxigu.se.logger.LoggerTestOne");
		logger.log(Level.INFO, "出错");
	}
}
