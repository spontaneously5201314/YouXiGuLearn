package com.youxigu.se.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月12日 下午6:26:06
*/
public class Log4jTestOne {
	static Logger logger = Logger.getLogger(Log4jTestOne.class.getName());
//	Log4jTestOne.class.getResourceAsStream("log4j.properties");
	public static void main(String[] args) {
		//默认读取的是项目根目录的路径、此时的log4j.properties要放在项目目录下
		PropertyConfigurator.configure("log4j.properties");
		logger.error("错误");
		logger.debug("i want to fuck you");
//		logger.info(message, t);
	}
}
