package com.softedge.demo.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.softedge.demo.model.Customer;
import com.softedge.demo.model.Employee;
import com.softedge.demo.model.Person;

public class SessionFactoryProvider {

	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	static {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
				.configure().build();
		sessionFactory = new MetadataSources(registry)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Customer.class)
				.addAnnotatedClass(Person.class)
				.buildMetadata().buildSessionFactory();
	}
}
