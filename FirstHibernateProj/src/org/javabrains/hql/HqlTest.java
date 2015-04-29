package org.javabrains.hql;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HqlTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		Query query = session.createQuery("select userName from UserDetails"); // Hibernate Query Language
		query.setFirstResult(5);
		query.setMaxResults(4);
		
		List<String> userNames = (List<String>) query.list(); // returns the list of all the records from a specified table
		
		session.getTransaction().commit();
		
		session.close();
		

		
		for (String s : userNames)
		{
			System.out.println(s);
		}
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