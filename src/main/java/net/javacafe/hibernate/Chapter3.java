
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
