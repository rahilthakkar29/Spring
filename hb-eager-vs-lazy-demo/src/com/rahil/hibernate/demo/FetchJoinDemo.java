package com.rahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.rahil.hibernate.demo.entity.Course;
import com.rahil.hibernate.demo.entity.Instructor;
import com.rahil.hibernate.demo.entity.InstructorDetail;


public class FetchJoinDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
								
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {


			// start a transaction
			session.beginTransaction();
			
			
			// option 2: Hibernate query with HQL
			
			// get the instructor from db
			int theId = 1;
			
			Query<Instructor> query = 
					session.createQuery("select i from Instructor i "
							+ "JOIN FETCH i.courses "
							+"where i.id=:theInstructorId", 
							Instructor.class);
			
			// set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// execute query and get instructor
			Instructor tempInstructor = query.getSingleResult();

			
			// print the instructor
			System.out.println("Rahil: Instructor: " + tempInstructor);
			
			

			
			// commit transaction
			session.getTransaction().commit();
			
			// closing the session
			session.close();
			System.out.println("\n\n Session Closed\n\n");
			System.out.println("Rahil: Courses: " +tempInstructor.getCourses());
			
			System.out.println("Rahil: Done!");

			}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
