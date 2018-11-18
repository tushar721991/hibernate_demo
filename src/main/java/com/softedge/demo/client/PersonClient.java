package com.softedge.demo.client;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.softedge.demo.model.Address;
import com.softedge.demo.model.Person;
import com.softedge.demo.util.SessionFactoryProvider;

public class PersonClient {

	public static void main(String[] args) {
		Set<Address> addresses = new HashSet<>();
		Address address1 = new Address("LBS Marg", "Mumbai", "Maharashtra", 400003);
		Address address2 = new Address("Subhash Road", "Dombivali", "Maharashtra", 421202);

		addresses.add(address1);
		addresses.add(address2);
	
		Person person = new Person("John Doe", 9988776655L, "johndoe@gmail.com", addresses);
		
		addPerson(person);
		
	}

	private static void addPerson(Person person) {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		System.out.println("Record saved successfully");
		session.close();
		factory.close();
				
	}
}
