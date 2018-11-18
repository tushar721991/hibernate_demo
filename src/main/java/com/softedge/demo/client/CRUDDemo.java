package com.softedge.demo.client;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.softedge.demo.model.Employee;
import com.softedge.demo.util.SessionFactoryProvider;

public class CRUDDemo {

	public static void main(String[] args) {
//		insert();
//		select();
//		update();
		delete();
	}

	private static void delete() {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = session.get(Employee.class, 101);

//		Employee employee = new Employee();
//		employee.setEmployeeId(101);
		session.delete(employee);
		
		tx.commit();
		session.close();
		factory.close();
	}

	private static void update() {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee employee = session.load(Employee.class, 101);
		System.out.println(employee);
		employee.setEmployeeSalary(50000);
		session.update(employee);
		System.out.println("Records updated Successfully");
		tx.commit();
		session.close();
		factory.close();		
	}

	private static void select() {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		//Get REcord from Database
		// public T get(Class<T> entityType, Serializable id)
		// public T load(Class<T> entityType, Serializable id)

		Employee employee = session.get(Employee.class, 101);
//		Employee employee = session.load(Employee.class, 101);
		System.out.println("=============================");
		System.out.println(employee);
		
		tx.commit();
		session.close();
		factory.close();
	}

	private static void insert() {
		SessionFactory factory = SessionFactoryProvider.getSessionFactory();

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		//inserting employee into employees table
		Employee employee = new Employee(101,  "John Doe", "HR", 34000);
		
		session.save(employee);
		tx.commit();
		session.close();
		factory.close();
	}
}
