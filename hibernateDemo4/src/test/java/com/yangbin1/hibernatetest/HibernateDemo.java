package com.yangbin1.hibernatetest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import com.yangbin1.entity.User;
import com.yangbin1.utils.HibernateUtils;

public class HibernateDemo {
	
	@Test
	public void testSaveOrUpdate() {

		// 加载hibernate核心配置文件
//		Configuration cfg = new Configuration();
//		cfg.configure();
//
//		// 创建sessionFactory
//		// 会根据映射关系创建表
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 创建session对象
		// 类似于连接
		Session session = sessionFactory.openSession();

		// 开启事务
		Transaction tx = session.beginTransaction();
		
		User user = new User();
		
		//瞬时态
		user.setUsername("jack");
		user.setPassword("456");
		user.setAddress("eeee");
		//瞬时态做添加
		session.saveOrUpdate(user);
		
		User user2 = new User();
		
		//托管态
		user2.setUid(2);
		user2.setUsername("eeee");
		user2.setPassword("456");
		user2.setAddress("fff");
		//托管态做更新
		session.saveOrUpdate(user2);
		
		// 调用session方法修改
		session.update(user);
		
		// 提交事务
		tx.commit();

		// 关闭资源
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testUpdate() {

		// 加载hibernate核心配置文件
//		Configuration cfg = new Configuration();
//		cfg.configure();
//
//		// 创建sessionFactory
//		// 会根据映射关系创建表
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 创建session对象
		// 类似于连接
		Session session = sessionFactory.openSession();

		// 开启事务
		Transaction tx = session.beginTransaction();

		// 根据id查询
		// 第一个参数：实体类class
		// 第二个参数: id
		User user = session.get(User.class, 2);		
		// 设值
		user.setUsername("dddd");
		
		// 调用session方法修改
		session.update(user);
		
		// 提交事务
		tx.commit();

		// 关闭资源
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testDelete() {

		// 加载hibernate核心配置文件
		// Configuration cfg = new Configuration();
		// cfg.configure();
		//
		// 创建sessionFactory
		// 会根据映射关系创建表
		// SessionFactory sessionFactory = cfg.buildSessionFactory();

		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 创建session对象
		// 类似于连接
		Session session = sessionFactory.openSession();

		// 开启事务
		Transaction tx = session.beginTransaction();

		// 根据id查询
		// 第一个参数：实体类class
		// 第二个参数: id
		User user = session.get(User.class, 2);

		// 调用session方法删除
		session.delete(user);

		// 提交事务
		tx.commit();

		// 关闭资源
		session.close();
		sessionFactory.close();
	}
	
	@Test
	public void testGet() {

		// 加载hibernate核心配置文件
//		Configuration cfg = new Configuration();
//		cfg.configure();
//
//		// 创建sessionFactory
//		// 会根据映射关系创建表
//		SessionFactory sessionFactory = cfg.buildSessionFactory();
		
		SessionFactory sessionFactory = HibernateUtils.getSessionFactory();

		// 创建session对象
		// 类似于连接
		Session session = sessionFactory.openSession();

		// 开启事务
		Transaction tx = session.beginTransaction();

		// 根据id查询
		// 第一个参数：实体类class
		// 第二个参数: id
		User user = session.get(User.class, 1);
		System.out.println(user);
		// 提交事务
		tx.commit();

		// 关闭资源
		session.close();
		sessionFactory.close();
	}

}
