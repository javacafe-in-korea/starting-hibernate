package net.javacafe.hibernate.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class UserTest {

	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		entityManagerFactory = Persistence
				.createEntityManagerFactory("starting-hibernate");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	}

	@After
	public void tearDown() throws Exception {
		entityTransaction.commit();
		entityManagerFactory.close();
	}

	@Test
	public void setName() {
		User u = new User();
		u.setName("HyungTae Lim");
		entityManager.persist(u);

	}

	@Test
	public void setAddress() {
		User u = new User();
		u.setName("HyungTae2 Lim2");
		User.Address a = new User.Address();
		a.setCity("Seoul");
		a.setStreet("Gangnam");
		a.setZipcode("130150");
		u.setHomeAddress(a);
		entityManager.persist(u);
	}

}
