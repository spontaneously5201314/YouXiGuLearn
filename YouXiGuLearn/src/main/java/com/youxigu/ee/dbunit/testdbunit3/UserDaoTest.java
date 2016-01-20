package com.youxigu.ee.dbunit.testdbunit3;

import static org.junit.Assert.fail;

import org.junit.Test;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 上午10:50:41
*/
public class UserDaoTest {
	
	private UserDao userDao = new UserDao();

	@Test
	public void testAdd() {
		User user = new User(1,"zhouzhou","123456","sb");
		userDao.add(user);
	}

	@Test
	public void testFindByUserName() {
		fail("Not yet implemented");
	}

}
