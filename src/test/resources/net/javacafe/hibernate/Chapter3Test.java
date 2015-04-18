package net.javacafe.hibernate;

import java.util.List;

import net.javacafe.hibernate.domain.AnnotatedMessage;
import net.javacafe.hibernate.domain.Message;
import net.javacafe.hibernate.util.HibernateSessionUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

public class Chapter3Test {
	
	// ¿œ¥Î¥Ÿ Test Case
	@Test
	public void OneAndManyTest() {
		Session session = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();

		

		tx.commit();
		session.close();

		Session newSession = HibernateSessionUtil.getSessionFactory().openSession();
		Transaction newTransaction = newSession.beginTransaction();
		List messages = newSession.createQuery(
				"from Message m order by m.text asc").list();

		System.out.println(messages.size() + " message(s) found:");

		for (Object m : messages) {
			Message loadedMsg = (Message) m;
			System.out.println(loadedMsg.getText());
		}

		newTransaction.commit();
		newSession.close();

		HibernateSessionUtil.shutdown();
		
	}
}
