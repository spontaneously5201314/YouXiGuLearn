package com.youxigu.se.logger;

import java.util.logging.ConsoleHandler;
import java.util.logging.Logger;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月12日 下午5:30:10
 */
public class LoggerTestTwo {

	public static void main(String[] args) {
		Logger logger = Logger.getAnonymousLogger();
//		logger.setLevel(MyLevel.SYSE);
//		// 记 录消息
//		logger.severe("SEVERE级消息");
//		logger.warning("WARNING 级消息");
//		logger.config("CONFIG级消息");
//		logger.info("INFO级消 息");
//		logger.fine("FINE级消息");
//		logger.finer("FINER级消息");
//		logger.finest("FINEST 级消息");
		ConsoleHandler handler = new ConsoleHandler();
		handler.setFormatter(new MyFormatter());
		logger.addHandler(handler);
		logger.setUseParentHandlers(false);
		logger.severe("SEVERE级消息");
		logger.warning("WARNING 级消息");
		logger.info("INFO级消 息");
		logger.config("CONFIG级消息");
		logger.fine("FINE级消息");
		logger.finer("FINER级消息");
		logger.finest("FINEST 级消息");
	}
}
