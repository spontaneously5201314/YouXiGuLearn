package com.youxigu.ee.dbunit.testdbunit3;

import org.hibernate.Session;

/**
 * @Description
 * @author Spontaneously
 * @time 2016年1月11日 上午10:31:40
 */
public class UserDao implements IUserDao {

	public void add(User user) {
		Session session = null;
		try {
			session = HibernateUtil.openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
	}

	public User findByUserName(String username) {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.openSession();
			user = (User) session.createQuery("from User where username=?").setParameter(0, username).uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			HibernateUtil.close(session);
		}
		return user;
	}
}
