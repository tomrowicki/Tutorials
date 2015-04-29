package org.koushik.criteria;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.koushik.criteria.UserDetails;

public class CriteriaTest {

	public static void main(String[] args) {

		SessionFactory sessionFactory = createSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		
		UserDetails exampleUser = new UserDetails();
//		exampleUser.setUserId(5);
		exampleUser.setUserName("User 6");
		
		Example example = Example.create(exampleUser);
		
		Criteria criteria = session.createCriteria(UserDetails.class)
//				.setProjection(Projections.property("userId")); // projections are used as a requirement for aggregation functions
//				.addOrder(Order.desc("userId"));
//		criteria.add(Restrictions.gt("userId", 5))
//				.add(Restrictions.eq("userName", "User 9"));
				.add(example); // used to tell hibernate to find similar objects
		
//		criteria.add(Restrictions.or(Restrictions.between("userId", 0, 3), Restrictions.between("userId", 7, 10)));
		
		
		@SuppressWarnings("unchecked")
		List<UserDetails> users = (List<UserDetails>) criteria.list();
//		List<Integer> ids = criteria.list();
		session.getTransaction().commit();
		
		session.close();
		
		for (UserDetails user : users)
		{
			System.out.println(user.getUserName());
		}
//		for (Integer id : ids)
//		{
//			System.out.println(id);
//		}
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