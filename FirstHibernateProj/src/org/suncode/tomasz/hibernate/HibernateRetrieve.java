package org.suncode.tomasz.hibernate;

import java.util.Iterator;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.suncode.tomasz.dto.tabela_testowa;

public class HibernateRetrieve {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Query query = session.createQuery("FROM tabela_testowa");

	    List l = query.list();
	    Iterator i1 = l.iterator();
	    
	    tabela_testowa obiekt = null;
	    while (i1.hasNext()) {
	        obiekt = (tabela_testowa)i1.next();
	        System.out.println(obiekt.toString());
	    }
	    session.close();
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
