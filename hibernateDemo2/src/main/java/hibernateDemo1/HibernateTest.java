package hibernateDemo1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.jdbc.Work;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("------初始化session工厂------");
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
		Person p = new Person("admin",123456,new Date());
		tx = session.beginTransaction();
		session.persist(p);
		tx.commit();
	}
	
	@Test
	public void testDoWork() {
		session.doWork(new Work() {

			public void execute(Connection connection) throws SQLException {
				System.out.println(connection);
			}

		});

	}
}
