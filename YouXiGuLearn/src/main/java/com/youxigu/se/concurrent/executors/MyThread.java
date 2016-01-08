package com.youxigu.se.concurrent.executors;

/**
 * @Description:
 * @author myg
 * @time 2015年12月4日 上午11:13:43
 */
public class MyThread implements Runnable {

	private int count = 1, number;

	public MyThread(int num) {
		number = num;
		System.out.println("Create Thread-" + number);
	}

	public void run() {
		while (true) {
			System.out.println("Thread-" + number + " run " + count + " time(s)");
			if (++count == 3)
				return;
		}
	}

}
