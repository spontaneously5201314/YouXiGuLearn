package com.youxigu.ee.dbunit.testdbunit3;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月11日 上午10:30:48
 */
public interface IUserDao {
	public void add(User user);

	public User findByUserName(String username);
}
