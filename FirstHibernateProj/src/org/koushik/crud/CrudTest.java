package org.koushik.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class CrudTest { // CRUD stands for Create Read Update Delete

	public static void main(String[] args) {

		
		
		
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
//		for(int i=0; i<10; i++){ // important to create users once the transaction is running
//			UserDetails user = new UserDetails();
//			user.setUserName("User " + i);
//			session.save(user);
//		}
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 6); // the second value is the id
//		session.delete(user);
		user.setUserName("Updated User");
		session.update(user);
		
		session.getTransaction().commit();
		
		session.close();
		System.out.print("User name pulled ups is: " + user.getUserName());
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