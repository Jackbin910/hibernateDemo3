package com.yangbin1.hibernatetest;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

import com.yangbin1.entity.User;
import com.yangbin1.utils.HibernateUtils;

public class hibernateSelect {
	
	@Test
	public void testCache() {

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 创建session对象s
		// 类似于连接
		Session session = sessionFactory.openSession();

		// 开启事务
		Transaction tx = session.beginTransaction();

		// 第一次查询
		User user1 = session.get(User.class, 1);

		System.out.println(user1);

		// 第二次查询
		User user2 = session.get(User.class, 1);

		System.out.println(user2);
		
		tx.commit();
	    session.close();
	    sessionFactory.close();

	}
	
	@Test
	public void testDemo() {
		Transaction tx = null;
		Session session = null;
		SessionFactory sessionFactory = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();

			// 创建session对象
			// 类似于连接
			session = sessionFactory.openSession();

			// 开启事务
			tx = session.beginTransaction();

			// 第一次查询
			User user1 = session.get(User.class, 1);
			user1.setUsername("yangbin2");

			tx.commit();

		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			sessionFactory.close();
		}

	}
}
