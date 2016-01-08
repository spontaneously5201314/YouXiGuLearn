package com.youxigu.junit;

import static org.junit.Assert.assertEquals;

import org.junit.Ignore;
import org.junit.Test;

/**
 * @Description:
 * @author myg
 * @time 2015年12月2日 下午2:18:23
 */
public class TestJunit {

	String message = "Robert";
	MessageUtil messageUtil = new MessageUtil(message);

	@Ignore
	@Test
	public void testPrintMessage() {
		System.out.println("Inside testPrintMessage()");
		message = "Robert";
		assertEquals(message, messageUtil.printMessage());
	}

	@Test
	public void testSalutationMessage() {
		System.out.println("Inside testSalutationMessage()");
		message = "Hi!" + "Robert";
		assertEquals(message, messageUtil.salutationMessage());
	}

}
