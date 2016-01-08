package com.youxigu.se.concurrent.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
* @Description: 使用future实现多线程的计算 菲波那切数列
* @author myg
* @time 2015年12月3日 下午5:32:36
*/
public class FutureTest {

	public static class Task1 implements Runnable{
		public void run() {
			System.out.print("sh");
		}
	}
	
	public static class Task2 implements Callable<String>{
		public String call() throws Exception {
			System.out.print("ah");
			return "something";
		}
	}
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newCachedThreadPool();
		long startTime1 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			es.submit(new Task1());
		}
		System.out.println("\n\r"+"runnable接口实现的没有返回值的并发编程总花费时间："+ (System.currentTimeMillis()-startTime1));
		long startTime2 = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			es.submit(new Task2());
		}
		System.out.println("\n\r"+"callable实现的存在返回值的并发编程总花费时间："+ (System.currentTimeMillis()-startTime2));
		long startTime3 = System.currentTimeMillis();
		List<Future<String>> results = new ArrayList<Future<String>>();
		for (int i = 0; i < 100; i++) {
			results.add(es.submit(new Task2()));
		}
//		for (Future<String> result : results) {
//			System.out.print(result.get());
//		}
		System.out.println("\n\r"+"同样是callable，使用Future获取返回值的并发编程总花费时间："+ (System.currentTimeMillis()-startTime3));
	}
}
