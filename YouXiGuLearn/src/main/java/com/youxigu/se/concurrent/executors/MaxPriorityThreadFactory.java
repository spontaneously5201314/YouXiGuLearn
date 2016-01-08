package com.youxigu.se.concurrent.executors;

import java.util.concurrent.ThreadFactory;

/**
 * @Description: 设置优先级属性-最高优先级
 * @author myg
 * @time 2015年12月4日 上午11:24:20
 */
public class MaxPriorityThreadFactory implements ThreadFactory {

	public Thread newThread(Runnable r) {
		Thread t = new Thread(r);
		t.setPriority(Thread.MAX_PRIORITY);
		return t;
	}

}
