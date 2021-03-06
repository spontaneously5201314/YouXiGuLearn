package com.youxigu.se.concurrent.future;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description:
 * @author myg
 * @time 2015年12月4日 上午10:27:16
 */
public class LiftOff implements Runnable {

	private int countDown = 10;
	private static int taskCount = 0;
	private final int id = taskCount++;

	public LiftOff() {
	}

	public LiftOff(int countDown) {
		this.countDown = countDown;
	}

	public String status() {
		return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff! ") + ")";
	}

	public void run() {
		while (countDown-- > 0) {
			System.out.print(status());
			Thread.yield();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(1);
		for (int i = 0; i < 5; i++) {
			exec.execute(new LiftOff());
		}
		exec.shutdown();
	}
}
