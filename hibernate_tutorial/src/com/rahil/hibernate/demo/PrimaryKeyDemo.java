package com.rahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	public static void main(String[] args) {
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {
			// use the session object to save java object

			// create 3 student objects
			System.out.println("Creating 3 new student objects...");
			Student tempStudent1 = new Student("Paul", "Wall", "paul@abc.com");
			Student tempStudent2 = new Student("Mary", "Doe", "mary@abc.com");
			Student tempStudent3 = new Student("Bonita", "Applebum", "bonita@abc.com");

			// start a transaction
			session.beginTransaction();

			// save the student object
			System.out.println("Saving the students...");
			session.save(tempStudent1);
			session.save(tempStudent3);
			session.save(tempStudent2);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}
	}
}
