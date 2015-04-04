package net.javacafe.hibernate;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import net.javacafe.hibernate.domain.Message;


public class Helloworld {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message("Hello World2");
		em.persist(message);
		
		tx.commit();
		em.close();
		
		EntityManager newEm = emf.createEntityManager();
		EntityTransaction newTx = newEm.getTransaction();
		newTx.begin();
		
		List messages = newEm
				.createQuery("select m from Message m order by m.text asc")
				.getResultList();
		
		System.out.println(messages.size() + " message(s) foooooound");
		
		for (Object m : messages) {
			Message loadedMsg = (Message) m;
			System.out.println(loadedMsg.getText());
		}
		
		newTx.commit();
		newEm.close();
		
		emf.close();
			
	}
		
}
