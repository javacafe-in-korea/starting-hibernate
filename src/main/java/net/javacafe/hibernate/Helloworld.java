package net.javacafe.hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import net.javacafe.hibernate.domain.AnnotatedMessage;
import net.javacafe.hibernate.domain.Message;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class Helloworld {

	//JPA
	public static void main(String[] args) {
		// EntityManagerFactory 시작
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("helloworld");
		
		// 첫 번째 작업 단위
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		
		Message message = new Message("Hello World");
		em.persist(message);
		
		tx.commit();
		em.close();
		
		// 두 번째 작업 단위
	}
	
	/*
	private static SessionFactory sessionFactory = new Configuration()
	.configure().buildSessionFactory();

	private static SessionFactory annotatedSessionFactory = new AnnotationConfiguration()
	.addPackage("net.javacafe.hibernate.domain")
	.addAnnotatedClass(AnnotatedMessage.class).configure()
	.buildSessionFactory();
	public static void main(String[] args) {
		//Annotation 방식
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();

		Message message = new Message("Hello World");
		session.save(message);

		tx.commit();
		session.close();

		Session secondSession = annotatedSessionFactory.openSession();
		Transaction secondTx = secondSession.beginTransaction();

		AnnotatedMessage annotatedMessage = new AnnotatedMessage("Hello World");
		secondSession.save(annotatedMessage);

		secondTx.commit();
		secondSession.close();

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
	*/
}
