package com.youxigu.memcached.xmemcached;

import com.youxigu.memcached.java_memcached.TestBean;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.utils.AddrUtil;

/**
* @Description: 
* @author myg
* @time 2015年11月30日 下午6:02:59
*/
public class TestXMemcachedDemo2 {

	public static void main(String[] args){
		XMemcachedClientBuilder builder = new XMemcachedClientBuilder(AddrUtil.getAddresses("127.0.0.1:11211"));
		MemcachedClient client = null;
		try {
			client = builder.build();
			client.add("test01", 0, new TestBean("zhangsan",23));
			client.add("test02", 10, "wofuckyou");
			client.add("test02", 10, "woaini");
			System.out.println(client.get("test01"));
			System.out.println(client.get("test02"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
