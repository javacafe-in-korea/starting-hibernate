package net.javacafe.hibernate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import net.javacafe.hibernate.domain.Category;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CategoryCRUD {
	
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
		
		Category queriedCategory = entityManager.find(Category.class, category.getId());
		
		assertThat(queriedCategory, equalTo(category));
	}
	
	@After
	public void destroy() {
		entityManagerFactory.close();
	}
}
