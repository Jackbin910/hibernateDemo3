package com.yangbin1.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

	static Configuration cfg = null;
	static SessionFactory sessionFactory = null;

	static {
		// 加载hibernate核心配置文件
		cfg = new Configuration();
		cfg.configure();

		// 创建sessionFactory
		// 会根据映射关系创建表
		sessionFactory = cfg.buildSessionFactory();
	}
	
	//返回与本地线程绑定的session方法
	public static Session getSessionObject(){
		return sessionFactory.getCurrentSession();
	}

	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static void main(String[] args) {
		
	}
}
