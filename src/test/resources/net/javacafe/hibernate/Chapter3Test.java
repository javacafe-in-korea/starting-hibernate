package net.javacafe.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jdk.nashorn.internal.ir.annotations.Ignore;
import net.javacafe.hibernate.model.Category;
import net.javacafe.hibernate.model.pojo.ItemPojo;
import net.javacafe.hibernate.model.pojo.UserPojo;
import net.javacafe.hibernate.util.HibernateSessionUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class Chapter3Test {
	
	// 일대다 Test Case
	@Test
	@Ignore
	public void OneToManyTest() {
		Session session = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		Category aPrent = new Category("parent1");
		Category aChild = new Category("child1");
		aChild.setParentCategory(aPrent);
		aPrent.getChildCategories().add(aChild);
		
		session.save(aPrent);
		session.save(aChild);
		
		tx.commit();
		session.close();

		Session newSession = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		List<Category> messages = newSession.createQuery(
				"from Category m order by m.name asc").list();

		System.out.println(messages.size() + " message(s) found:");

		for (Object m : messages) {
			Category loadedMsg = (Category) m;
			System.out.println(loadedMsg.getName());
		}

		newTransaction.commit();
		newSession.close();

		HibernateSessionUtil.shutdown();
	}
	
	// 다대다 Test
	@Test
	public void ManyToManyTest() {
		
		
		
		
	}
	
	// 동적 엔티티 Test
	@Test
	@Ignore
	public void DynamicEntityItemTest() {
		
		Session session = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		Map<String, Object> user = new HashMap<String, Object>();
		user.put("username", "johndoe");
		
		Map<String, Object> item1 = new HashMap<String, Object>();
		item1.put("description", "An item for auction");
		item1.put("initialPrice", new BigDecimal(99));
		item1.put("seller", user);
		
		Map<String, Object> item2 = new HashMap<String, Object>();
		item2.put("description", "Another item for auction");
		item2.put("initialPrice", new BigDecimal(123));
		item2.put("seller", user);
		
		Collection<Map<String, Object>> itemsForSale = new ArrayList<Map<String, Object>>();
		itemsForSale.add(item1);
		itemsForSale.add(item2);
		user.put("itemsForSale", itemsForSale);
		
		session.save("UserEntity",user);
		
		tx.commit();
		session.close();
		
		Session newSession = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		
		Long storedItemId = (Long) item1.get("id");
		Map loadedItemMap = (Map) newSession.load("ItemEntity", storedItemId);
		
		List queriedItemPojos = session.createQuery("from ItemEntity where initialPrice >= :p")
				   .setParameter("p", new BigDecimal(100))
				   .list();

		for (Object m : queriedItemPojos) {
			Map<String, Object> loadedMsg = (Map<String, Object>) m;
			UserPojo userPojo = (UserPojo) loadedMsg.get("seller");
			System.out.println(userPojo.getId());
		}

		newTransaction.commit();
		newSession.close();

		HibernateSessionUtil.shutdown();
	}
	
	// 동적&정적 엔티티 Test
	@Test
	public void DynamicEntityAndNativeEntityTest() {
		Session session = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		
		UserPojo user = new UserPojo();
		user.setUsername("johndoe");
		
		ItemPojo item1 = new ItemPojo();
		item1.setDescription("An item for auction");
		item1.setInitialPrice(new BigDecimal(133));
		item1.setSeller(user);
		
		ItemPojo item2 = new ItemPojo();
		item2.setDescription("Another item for auction");
		item2.setInitialPrice(new BigDecimal(233));
		item2.setSeller(user);
		
		Collection<ItemPojo> itemsForSale = new ArrayList<ItemPojo>();
		itemsForSale.add(item1);
		itemsForSale.add(item2);
		user.setItemsForSale(itemsForSale);
		
		session.save("UserEntity",user);
		
		tx.commit();	
		
		Long storedItemId = item1.getId();
		ItemPojo loadItemPojo = (ItemPojo) session.load("ItemEntity", storedItemId);
		
		List queriedItemPojos = session.createQuery("from ItemEntity where initialPrice >= :p")
									   .setParameter("p", new BigDecimal(100))
									   .list();
		
		for (Object m : queriedItemPojos) {
			ItemPojo loadedMsg = (ItemPojo) m;
			System.out.println(loadedMsg.getSeller().getId());
		}
		
		session.close();
		
		HibernateSessionUtil.shutdown();
	}
}
