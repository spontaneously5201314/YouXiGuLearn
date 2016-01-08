package com.youxigu.se.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
* @Description: 
* @author myg
* @time 2015年12月4日 上午11:14:36
*/
public class CachedThreadPool {

	public static void main(String[] args) {
		//创建一个可根据需要创建新线程的线程池，但是在以前构造的线程可用时将重用它们。对于执行很多短期异步任务的程序而言，这些线程池通常可提高程序性能。
//		ExecutorService exec = Executors.newCachedThreadPool();
		//创建一个可重用固定线程数的线程池，以共享的无界队列方式来运行这些线程。
//		ExecutorService exec = Executors.newFixedThreadPool(2);
		//创建一个使用单个 worker 线程的 Executor，以无界队列方式来运行该线程。
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for (int i = 0; i < 5; i++) {
			exec.execute(new MyThread(i));
		}
		exec.shutdown();
	}
}
