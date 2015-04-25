package net.javacafe.hibernate.util;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateSessionUtil {

	private static SessionFactory sessionFactory;
	private static SessionFactory annotatedSessionFactory;
	private static ServiceRegistry serviceRegistry;
	private static ServiceRegistry annotatedServiceRegistry;
	
	HibernateSessionUtil() {		
	}
	
	static {
		try{
			Configuration configuration = new Configuration();
		    configuration.configure();
		    serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
		            configuration.getProperties()).build();
		    sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		  
		    Configuration annotatedConfiguration = new AnnotationConfiguration();
		    //annotatedConfiguration.setNamingStrategy(new CENamingStrategy());
		    annotatedConfiguration.configure();
		    annotatedServiceRegistry = new StandardServiceRegistryBuilder().applySettings(
		    		annotatedConfiguration.getProperties()).build();
		    annotatedSessionFactory = annotatedConfiguration.buildSessionFactory(annotatedServiceRegistry);
		} catch (Throwable ex) {
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static SessionFactory getAnnotatedSessionFactory() {
		return annotatedSessionFactory;
	}
	
	public static void shutdown() {
		sessionFactory.close();
	}
	
	public static void anotatedShutdown() {
		annotatedSessionFactory.close();
	}
		
}

