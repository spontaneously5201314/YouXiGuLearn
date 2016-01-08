package com.youxigu.se.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author myg
 * @time 2015年12月4日 上午11:25:52
 */
public class ExecFromFactory {

	public static void main(String[] args) {
		ExecutorService defaultExec = Executors.newCachedThreadPool();
		ExecutorService daemonExec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		ExecutorService maxPriorityExec = Executors.newCachedThreadPool(new MaxPriorityThreadFactory());
		ExecutorService minPriorityExec = Executors.newCachedThreadPool(new MinPriorityThreadFactory());
		for (int i = 0; i < 10; i++)
			daemonExec.execute(new MyThread(i));
		for (int i = 10; i < 20; i++)
			if (i == 10)
				maxPriorityExec.execute(new MyThread(i));
			else if (i == 11)
				minPriorityExec.execute(new MyThread(i));
			else
				defaultExec.execute(new MyThread(i));
	}
}
