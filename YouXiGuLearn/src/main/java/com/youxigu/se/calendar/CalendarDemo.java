package com.youxigu.se.calendar;

import java.util.Calendar;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 下午3:30:46
*/
public class CalendarDemo {

	public static void main(String[] args) {
		Calendar c = Calendar.getInstance();
		int day1 = c.get(Calendar.DAY_OF_YEAR);
		int day2 = c.get(Calendar.DAY_OF_MONTH);
		int day3 = c.get(Calendar.DAY_OF_WEEK);
		System.out.println(day1);
		System.out.println(day2);
		System.out.println(day3);
//		System.out.println(calendar);
//		System.out.println(calendar.getFirstDayOfWeek());
//		System.out.println(Calendar.DAY_OF_YEAR);
//		Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//		System.out.println(timeStamp);
//		System.out.println(new Date(System.currentTimeMillis()));
//		System.out.println(timeStamp.toString());
//		System.out.println(timeStamp.getTimezoneOffset());
	}
}
