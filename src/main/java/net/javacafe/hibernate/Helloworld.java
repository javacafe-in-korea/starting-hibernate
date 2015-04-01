package net.javacafe.hibernate;

import java.util.List;

import net.javacafe.hibernate.domain.Message;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Helloworld {
	private static SessionFactory sessionFactory = new Configuration()
			.configure().buildSessionFactory();

	public static void main(String[] args) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Message message = new Message("Hello World");
		Long msgId = (Long) session.save(message);

		tx.commit();
		session.close();

		Session newSession = sessionFactory.openSession();
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

		sessionFactory.close();
	}
}
