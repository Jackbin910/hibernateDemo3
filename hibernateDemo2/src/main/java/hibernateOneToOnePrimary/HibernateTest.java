package hibernateOneToOnePrimary;

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
	public void testSave(){
		Department department = new Department();
		department.setDeptName("AA");
		
		Manager manager  = new Manager();
		manager.setMgrName("MM");
		department.setMgr(manager);
		manager.setDept(department);
		session.save(department);
		session.save(manager);
	}

}
