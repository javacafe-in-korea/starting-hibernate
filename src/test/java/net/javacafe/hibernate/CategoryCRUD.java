package net.javacafe.hibernate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import net.javacafe.hibernate.domain.Category;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class CategoryCRUD {
	private static Logger logger = LoggerFactory.getLogger(CategoryCRUD.class);
	
	private EntityManager entityManager;
	private EntityManagerFactory entityManagerFactory;
	private EntityTransaction entityTransaction;
	
	@Before
	public void init() {
		entityManagerFactory = Persistence.createEntityManagerFactory("javacafe");
		entityManager = entityManagerFactory.createEntityManager();
		entityTransaction = entityManager.getTransaction();
	}
	
	@Test
	public void 메시지삽입() {
		entityTransaction.begin();
		Category category = new Category();
		category.setName("sports");
		entityManager.persist(category);
		entityTransaction.commit();
		
		logger.info(category.toString());
		Category queriedCategory = entityManager.find(Category.class, category.getId());
		
		assertThat(queriedCategory, equalTo(category));
	}
	
	@After
	public void destroy() {
		entityManagerFactory.close();
	}
}
