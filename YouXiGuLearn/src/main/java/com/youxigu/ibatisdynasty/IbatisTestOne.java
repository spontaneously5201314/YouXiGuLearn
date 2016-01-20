package com.youxigu.ibatisdynasty;

import org.hibernate.CacheMode;

import com.ibatis.sqlmap.engine.cache.memcached.MemcachedManager;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月15日 上午10:52:38
*/
public class IbatisTestOne {

	public static void main(String[] args) {
		MemcachedManager manager = new MemcachedManager();
		manager.set("1", 1);
		System.out.println(manager.get("1"));
	}
}
