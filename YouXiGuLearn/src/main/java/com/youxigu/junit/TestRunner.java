package com.youxigu.junit;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * @Description:
 * @author myg
 * @time 2015年12月2日 下午2:23:07
 */
public class TestRunner {

	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(TestJunit.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println(result.wasSuccessful());
	}
}
