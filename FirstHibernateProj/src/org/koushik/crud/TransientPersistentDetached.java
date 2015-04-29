package org.koushik.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class TransientPersistentDetached {

public static void main(String[] args) {

		UserDetails user = new UserDetails();
		user.setUserName("Test User"); // at this object is transient
	
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(user); // the object becomes persistent here
		
		user.setUserName("Updated User"); // this does update the database
		
		session.getTransaction().commit();
		
		session.close();
		
		user.setUserName("Updated after session closes"); // now the object is in a detached state and does not go into db
	}
	
	private static SessionFactory sessionFactory;
	private static ServiceRegistry serviceRegistry;
	
	public static SessionFactory createSessionFactory() {
				
		Configuration configuration = new Configuration();
		configuration.configure();
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
				configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		return sessionFactory;
	}
}