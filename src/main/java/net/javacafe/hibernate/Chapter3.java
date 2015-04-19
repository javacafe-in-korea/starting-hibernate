
package net.javacafe.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javacafe.hibernate.domain.Message;
import net.javacafe.hibernate.model.Category;
import net.javacafe.hibernate.model.pojo.ItemPojo;
import net.javacafe.hibernate.model.pojo.UserPojo;
import net.javacafe.hibernate.util.HibernateSessionUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Chapter3 {
	
	public static void main(String args[]) {
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
}
