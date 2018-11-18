package com.softedge.demo.client;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.softedge.demo.model.Address;
import com.softedge.demo.model.Customer;
import com.softedge.demo.util.SessionFactoryProvider;

public class CustmerClient {

	public static void main(String[] args) {
/*		Address address = new Address("LBS Marg", "Mumbai", "Maharashtra", 400003);
		Customer customer = new Customer(101, "John Doe", 8898554466L, address);
		addCustomer(customer);
*/		
		Customer c = getCustomer(101);
		System.out.println(c);
	}
	
	private static Customer getCustomer(Serializable customerId) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Customer customer = session.get(Customer.class, customerId);
		System.out.println("Record saved successfully");
		session.close();
		factory.close();
		return customer;
	}

	private static void addCustomer(Customer customer) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(customer);
		tx.commit();
		System.out.println("Record saved successfully");
		session.close();
		factory.close();
		
	};
	
}
