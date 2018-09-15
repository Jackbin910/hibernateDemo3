package hibernateDemoN21;

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
		System.out.println("-----初始化数据");
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

	}

	@After
	public void tearDown() throws Exception {
		tx.commit();
		session.close();
	}

	@Test
	public void testMany2One() {
		Customer customer = new Customer();
		customer.setCustomerName("AA");
		Order order = new Order();
		order.setOrderName("order-1");
		Order order2 = new Order();
		order2.setOrderName("order-2");
		order.setCustomer(customer);
		order2.setCustomer(customer);
		session.save(customer);
		session.save(order);
		session.save(order2);

	}

}
