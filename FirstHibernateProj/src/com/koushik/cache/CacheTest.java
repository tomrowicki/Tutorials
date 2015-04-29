package com.koushik.cache;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.service.ServiceRegistry;
import org.koushik.criteria.UserDetails;

public class CacheTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails user = (UserDetails) session.get(UserDetails.class, 1);
		user.setUserName("Updated User"); // hibernate knows it needs to perform only 2 queries in one session (getting 2 users and updating 1)
		
//		UserDetails user2 = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		
		session.close();
		
		Session session2 = sessionFactory.openSession();
		session2.beginTransaction();
		UserDetails user2 = (UserDetails) session2.get(UserDetails.class, 1);
		session2.getTransaction().commit();
		session2.close();
		
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