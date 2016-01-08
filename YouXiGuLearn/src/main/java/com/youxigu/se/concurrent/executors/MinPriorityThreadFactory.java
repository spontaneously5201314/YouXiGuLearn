package com.youxigu.se.concurrent.executors;

import java.util.concurrent.ThreadFactory;

/**
 * @Description: 最低优先级
 * @author myg
 * @time 2015年12月4日 上午11:25:14
 */
public class MinPriorityThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MIN_PRIORITY);
		return t;
	}

}
