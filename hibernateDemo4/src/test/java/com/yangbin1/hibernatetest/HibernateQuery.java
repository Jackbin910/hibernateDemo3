package com.yangbin1.hibernatetest;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.junit.Test;

import com.yangbin1.entity.User;
import com.yangbin1.utils.HibernateUtils;

public class HibernateQuery {

	// 使用Query对象
	@Test
	public void testQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			//创建query对象
			//写HQL语句
	        Query query= session.createQuery("from User");
	        List<User> list = query.list();
	        for (User user : list){
	        	System.out.println(user);
	        }
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}

	@Test
	public void testCriteria() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 创建Criteria对象
			// 写HQL语句
			Criteria criteria = session.createCriteria(User.class);
			List<User> list = criteria.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
	
	@Test
	public void testSqlQuery() {
		SessionFactory sessionFactory = null;
		Session session = null;
		Transaction tx = null;
		try {
			sessionFactory = HibernateUtils.getSessionFactory();
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			// 创建Criteria对象
			// 写HQL语句
			SQLQuery sqlQuery = session.createSQLQuery("select * from t_user");
			// List<Object[]> list = sqlQuery.list();
			// for (Object[] obj : list) {
			// System.out.println(Arrays.toString(obj));
			// }
			sqlQuery.addEntity(User.class);
			List<User> list = sqlQuery.list();
			for (User user : list) {
				System.out.println(user);
			}
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			tx.rollback();
		} finally {
			session.close();
			sessionFactory.close();
		}
	}
}
