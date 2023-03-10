package com.rahil.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();

		// create session
		Session session = factory.getCurrentSession();

		try {

			// start a transaction
			session.beginTransaction();

			// query students
			List<Student> theStudents = session.createQuery("from Student").list();

			// display the students
			theStudents.forEach(System.out::println);

			// query students: lastName='Smith'
			theStudents = session.createQuery("from Student s where s.lastName='Smith'").list();

			System.out.println("\n\n\nStudents who have last name Smith");
			theStudents.forEach(System.out::println);

			// query students: lastName='Smith' OR firstName='Daffy'
			theStudents = session.createQuery("from Student s where" + " s.lastName='Smith' OR s.firstName='Daffy'")
					.list();

			System.out.println("\n\n\nStudents who have last name Smith or first name Daffy");
			theStudents.forEach(System.out::println);

			// query students: email like='abc.com'
			theStudents = session.createQuery("from Student s where"
					+ " s.email LIKE '%abc.com%'")
					.list();

			System.out.println("\n\n\nStudents who have email like abc.com");
			theStudents.forEach(System.out::println);

			// commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
