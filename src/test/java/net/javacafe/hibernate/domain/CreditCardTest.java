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

public class CreditCardTest {
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
	public void testGetNumber() throws Exception {
		CreditCard c = new CreditCard();
		c.setExpMonth("09");
		c.setExpYear("19");
		c.setNumber("12341234123412341234");
		entityManager.persist(c);
	}

}
