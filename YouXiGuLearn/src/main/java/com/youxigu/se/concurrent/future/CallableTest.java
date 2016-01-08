package com.youxigu.se.concurrent.future;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
* @Description: 
* @author myg
* @time 2015年12月4日 上午10:11:46
*/
public class CallableTest {
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		ExecutorService exec = Executors.newCachedThreadPool();
		//Future 相当于是用来存放Executor执行的结果的一种容器  
		ArrayList<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 10; i++) {
			if(i==9)
				(exec.submit(new TaskWithResult(i))).cancel(true);
			else
				results.add(exec.submit(new TaskWithResult(i)));
		}
		for (Future<String> fs : results) {
			if(fs.isDone())
				System.out.println(fs.get(5000,TimeUnit.MICROSECONDS));
			else
				System.out.println("Future result is not yet complete");
		}
		exec.shutdown();
	}
	
}

class TaskWithResult implements Callable<String>{

	private int id;
	
	public TaskWithResult(int id) {
		this.id = id;
	}

	public String call() throws Exception {
		int i = 1/0;
		return "result of TaskWithResult " + id;
	}
	
}
