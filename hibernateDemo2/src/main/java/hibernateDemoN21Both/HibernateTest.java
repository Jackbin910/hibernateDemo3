package hibernateDemoN21Both;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HibernateTest {
	SessionFactory sessionFactory = null;
	Session session = null;
	Transaction tx = null;

	@Before
	public void setUp() throws Exception {
		System.out.println("-------初始化开始------");
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
		session = sessionFactory.openSession();
		tx = session.beginTransaction();

	}

	@After
	public void tearDown() throws Exception {
		System.out.println("-------结束-------");
		tx.commit();
		session.close();
	}

	@Test
	public void testMany2OneGet() {
		Customer customer = session.get(Customer.class, 1);
		System.out.println(customer.getCustomerName());

	}

	@Test
	public void testMany2One() {
		Customer customer = new Customer();
		customer.setCustomerName("BB");

		Order order = new Order();
		order.setOrderName("order-3");
		Order order2 = new Order();
		order2.setOrderName("order-4");

		order.setCustomer(customer);
		order2.setCustomer(customer);

		customer.getOrders().add(order);
		customer.getOrders().add(order2);

		session.save(customer);
		session.save(order);
		session.save(order2);

	}

}
