
package net.javacafe.hibernate;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.javacafe.hibernate.domain.Message;
import net.javacafe.hibernate.model.Address;
import net.javacafe.hibernate.model.Category;
import net.javacafe.hibernate.model.Item;
import net.javacafe.hibernate.model.User;
import net.javacafe.hibernate.model.pojo.ItemPojo;
import net.javacafe.hibernate.model.pojo.UserPojo;
import net.javacafe.hibernate.util.HibernateSessionUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Chapter3 {
	
	public static void main(String args[]) {
		Session session = HibernateSessionUtil.getAnnotatedSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

//		Category aPrent = new Category("parent1");
//		Category aChild = new Category("child1");
//		aChild.setParentCategory(aPrent);
//		aPrent.getChildCategories().add(aChild);
//		
//		session.save(aPrent);
//		session.save(aChild);
		
		User user = new User();
		user.setLoginName("asdasd");
		
		Address homeAddress = new Address();
		homeAddress.setCity("city1");
		homeAddress.setStreet("homeStreet");
		homeAddress.setZipcode("1111");
		
		Address billingAddress = new Address();
		billingAddress.setCity("city2");
		billingAddress.setStreet("billingStreet");
		billingAddress.setZipcode("2222");
		
		user.setHomeAddress(homeAddress);
		user.setBillingAddress(billingAddress);		
		
		session.save(user);
		
		tx.commit();
		session.close();

		Session newSession = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		List<User> messages = newSession.createQuery(
				"from User m").list();

		System.out.println(messages.size() + " message(s) found:");

		for (Object m : messages) {
			User loadedMsg = (User) m;
			System.out.println(loadedMsg.getHomeAddress());
			System.out.println(loadedMsg.getBillingAddress());
			
			//System.out.println(loadedMsg.getAddress().getUser().getName());
		}

		newTransaction.commit();
		newSession.close();

		HibernateSessionUtil.shutdown();
	}
}
