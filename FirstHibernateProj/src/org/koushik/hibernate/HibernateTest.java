package org.koushik.hibernate;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.javabrains.koushik.dto.Address;
import org.javabrains.koushik.dto.UserDetails;
import org.javabrains.koushik.dto.Vehicle;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails user = new UserDetails();
		//user.setUserId(1);
		user.setUserName("First User");
//		//user.setAddress("First user's address");
//		user.setJoinedDate(new Date());
//		user.setDescription("First user's description goes here.");
//		Address addr = new Address();
//		addr.setStreet("Street Name");
//		addr.setCity("City Name");
//		addr.setState("State Name");
//		addr.setPincode("Pincode");
//		//user.setHomeAddress(addr);
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
//		user.setVehicle(vehicle);
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("Jeep");
		
		user.getVehicle().add(vehicle);
		user.getVehicle().add(vehicle2);
//		vehicle.setUser(user);
//		vehicle2.setUser(user);
//		vehicle.getUserList().add(user);
//		vehicle2.getUserList().add(user);
		
		Address addr2 = new Address();
		addr2.setStreet("Second Street Name");
		addr2.setCity("Second City Name");
		addr2.setState("Second State Name");
		addr2.setPincode("Second Pincode");
		//user.setOfficeAddress(addr2);
//		user.getListOfAddresses().add(addr);
//		user.getListOfAddresses().add(addr2);
		
		UserDetails user2 = new UserDetails();
		//user2.setUserId(2);
		user2.setUserName("Second User");
		
		SessionFactory sessionFactory = createSessionFactory(); // this is only done once
		Session session = sessionFactory.openSession(); // saving to db procedure starts here
		session.beginTransaction();
		session.persist(user);
//		session.save(vehicle); // taken care of by the cascade annotaion in the UserDetails class
//		session.save(vehicle2);
		session.persist(user2);
		session.getTransaction().commit();
		session.close();

		user = null; // resetting the objects
		user2 = null;
		
		session = sessionFactory.openSession(); // retrieving from db starts here
		session.beginTransaction();
		user2 = (UserDetails) session.get(UserDetails.class, 2);  // (UserDetails) is used for casting, necessary for storing certain values instead of whole object
		// user2.getListOfAddresses(); this submits another query to the db (the first being the one above) and is called the eager initialisation; if we only ask about things we need once then that is called lazy initialisation
		System.out.println(user2);
		session.close();
		
//		System.out.println(user2.getListOfAddresses().size()); // can be done in an eager way with closed session (eager fetching needs to be declared in UserDetails class)
		
		/*UserDetails user2 = null; // portion for reading data from table
		session = sessionFactory.openSession();
		session.beginTransaction();
		user2 = (UserDetails) session.get(UserDetails.class, 2);
		System.out.println(user2);
		System.out.println(session.createCriteria(UserDetails.class).list());
		Query query = session.createQuery("from UserDetails");

	    List l = query.list();
	    Iterator i1 = l.iterator();

	    UserDetails commObject = null;
	    while (i1.hasNext()) {
	        commObject = (UserDetails)i1.next();
	        System.out.println(commObject.toString());*/
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
