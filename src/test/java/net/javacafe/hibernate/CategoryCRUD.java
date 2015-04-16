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
	public void 카테고리생성() {
		entityTransaction.begin();
		Category category = new Category();
		category.setName("sports");
		entityManager.persist(category);
		entityTransaction.commit();
		
		logger.info(category.toString());
		Category queriedCategory = entityManager.find(Category.class, category.getId());
		
		assertThat(queriedCategory, equalTo(category));
	}
	
	@Test
	public void 계층형카테고리생성() {
		entityTransaction.begin();

		// parent category 생성
		Category parentCategory = new Category();
		parentCategory.setName("sports");
		entityManager.persist(parentCategory);

		// child category 생성
		Category childCategory = new Category();
		childCategory.setName("baseball");

		// child parent 관계 설정
		parentCategory.addChildCategory(childCategory);
		// 아래 코드로 실행하면 예외 발생!! Good :)
//		childCategory.setParentCategory(parentCategory);
//		parentCategory.getChildCategories().add(childCategory);
		entityManager.persist(childCategory);
		
		entityTransaction.commit();
		
		// 검증
		Category queriedCategory = entityManager.find(Category.class, childCategory.getId());
		assertThat(queriedCategory.getParentCategory(), equalTo(parentCategory));
	}
	
	@After
	public void destroy() {
		entityManagerFactory.close();
	}
}
