package com.youxigu.se.concurrent.executors;

import java.util.concurrent.ThreadFactory;

/**
* @Description: 设置后台线程属性
* @author myg
* @time 2015年12月4日 上午11:22:06
*/
public class DaemonThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setDaemon(true);
		return t;
	}

}
