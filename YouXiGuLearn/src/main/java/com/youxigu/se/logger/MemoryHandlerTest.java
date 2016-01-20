package com.youxigu.se.logger;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.MemoryHandler;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月12日 下午5:19:53
 */
public class MemoryHandlerTest {
	FileHandler fhandler;
	Logger logger;
	MemoryHandler mhandler;

	MemoryHandlerTest() {
		try {
			// 构造名为my.log的日志记录文件
			fhandler = new FileHandler("my.log");
			int numRec = 5;
			// 构造一个5个日志记录的MemoryHandler，
			// 其目标Handler为一个FileHandler
			mhandler = new MemoryHandler(fhandler, numRec, Level.OFF);
			// 构造一个记录器
			logger = Logger.getLogger("com.mycompany");
			// 为记录器添加一个MemoryHandler
			logger.addHandler(mhandler);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		MemoryHandlerTest mt = new MemoryHandlerTest();
		int trigger = (int) (Math.random() * 100);
		for (int i = 1; i < 100; i++) {
			// 在MemoryHandler中缓存日志记录
			mt.logger.log(Level.INFO, "日志记录" + i);
			if (i == trigger) {
				// 触发事件成立，显式调用MemoryHandler的
				// push方法触发目标Handler输出日志记录到
				// my.log文件中
				// 当且仅当这个事件成立的时候就触发这个事件了！
				mt.mhandler.push();
				break;
			}
		}
	}
}
