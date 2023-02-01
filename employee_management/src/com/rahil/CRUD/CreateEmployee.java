package com.rahil.CRUD;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.entity.Employee;

public class CreateEmployee {

	public void create(String firstName, String lastName, String company) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {
			
			Employee tempEmployee = new Employee(firstName, lastName, company);
			
			session.beginTransaction();
			
			session.save(tempEmployee);
			
			session.getTransaction().commit();
			
			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
	
}
