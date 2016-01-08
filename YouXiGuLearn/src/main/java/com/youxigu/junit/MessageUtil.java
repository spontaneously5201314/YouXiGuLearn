package com.youxigu.junit;

/**
 * @Description:
 * @author myg
 * @time 2015年12月2日 下午2:16:08
 */
public class MessageUtil {

	private String message;

	public MessageUtil(String message) {
		this.message = message;
	}

	public String printMessage() {
		System.out.println(message);
		return message;
	}

	public String salutationMessage() {
		message = "Hi!" + message;
		System.out.println(message);
		return message;
	}

}
