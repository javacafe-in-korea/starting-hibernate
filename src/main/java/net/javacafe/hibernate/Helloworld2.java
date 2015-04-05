package net.javacafe.hibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import net.javacafe.hibernate.domain.AnnotatedMessage;
import net.javacafe.hibernate.domain.Message;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Helloworld2 {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message("Hello World");
		em.persist(message);
		
		tx.commit();
		em.close();
		
		EntityManager newEm = emf.createEntityManager();
		EntityTransaction newTx = newEm.getTransaction();
		newTx.begin();
		
		List<?> messages = newEm
				.createQuery("select m from Message m order by m.text asc")
				.getResultList();
		
		System.out.println(messages.size() + " message(s) found");
		
		for (Object m : messages) {
			Message loadedMsg = (Message) m;
			System.out.println(loadedMsg.getText());
		}
		
		newTx.commit();
		newEm.close();
		
		emf.close();
	}
}
