package com.rahil.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.entity.Employee;

public class ReadById {

	public void read(int id) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			session.beginTransaction();
			
			Employee myEmployee = session.get(Employee.class, id);
			
			
			
			session.getTransaction().commit();
			
			System.out.println("The result: " + myEmployee);
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}
	
}
