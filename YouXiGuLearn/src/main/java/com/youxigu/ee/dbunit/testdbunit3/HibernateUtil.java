package com.youxigu.ee.dbunit.testdbunit3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
* @Description 
* @author Spontaneously
* @time 2016年1月11日 上午10:36:53
*/
public class HibernateUtil {
	private static SessionFactory sessionFactory = buildSessionFactory();
	 
	  private static SessionFactory buildSessionFactory() {
	    Configuration configuration = new Configuration().configure();
	    ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties())
	        .buildServiceRegistry();
	    return configuration.buildSessionFactory(serviceRegistry);
	  }
	 
	  public static SessionFactory getSessionFactory() {
	    return sessionFactory;
	  }
	 
	  public static Session openSession() {
	    return sessionFactory.openSession();
	  }
	 
	  public static void close(Session session) {
	    if (session != null) {
	      session.close();
	    }
	  }
}
