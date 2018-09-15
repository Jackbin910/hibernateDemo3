package hibernateDemo1;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest1 {
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("-----初始化数据");
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();

	}

	@After
	public void tearDown() throws Exception {
		if (session.isOpen()) {
			session.close();
		}
	}

	@Test
	public void test() {
		News p = new News("y","s",new Date());
		tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
	}
	
	@Test
	public void test1() {
		News p = session.get(News.class, 1);
		p.setTitle("title");
		System.out.println(p.getDesc());
		tx.commit();
	}

}
