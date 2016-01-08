package com.youxigu.se.concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
* @Description: FutureTask实现超时执行的代码
* @author myg
* @time 2015年12月3日 下午4:41:11
*/
public class TimeOut {
	private static String result = null;
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		/*//1.直接构造future对象
		FutureTask<String> future = new FutureTask<String>(new Callable<String>(){
			//使用Callable接口作为构造参数
			public String call() throws Exception {
				//真正的任务在这里执行，这里的返回值类型为String，可以为任意类型   
				return "beijing ...";
			}
		});*/
		//2.不直接构造future对象
		FutureTask<String> future = (FutureTask<String>) executor.submit(new Callable<String>(){

			public String call() throws Exception {
				//真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
				return "tianjing ...";
			}
		});
		executor.execute(future);
		//在这里可以做别的任何事情
		try {
			//取得结果，同时设置超时执行时间为5秒。同样可以用future.get()，不设置执行超时时间取得结果   
			result = future.get(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			future.cancel(true);
		} catch (ExecutionException e) {
			future.cancel(true);
		} catch (TimeoutException e) {
			future.cancel(true);
		}finally{
			executor.shutdown();
		}
		System.out.println(result);
	}
}
