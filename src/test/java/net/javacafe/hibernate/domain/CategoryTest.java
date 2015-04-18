/**
 * 
 */
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

public class CategoryTest {
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
	}

	@After
	public void tearDown() throws Exception {
		entityManagerFactory.close();
	}

	@Test
	public void testCreate() {
		entityTransaction.begin();
		Category c = new Category();
		c.setName("Category 1");
		entityManager.persist(c);
		entityTransaction.commit();
	}

}
