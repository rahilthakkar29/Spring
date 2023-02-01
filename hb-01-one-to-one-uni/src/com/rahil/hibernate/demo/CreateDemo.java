package com.rahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.hibernate.demo.entity.Instructor;
import com.rahil.hibernate.demo.entity.InstructorDetail;


public class CreateDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
								
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {

			// create the objects
			Instructor tempInstructor = new Instructor("Nehali", "Shah", "nehali@abc.com");
			
			InstructorDetail tempInstructorDetail =
					new InstructorDetail("http://nehali.com",
							"Cooking");

			// associate the objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			
			// start a transaction
			session.beginTransaction();
			
			// save the instructor
			//
			// Note: this will ALSO save the details object
			// because of CascadeType.ALL
			//
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

			}
		finally {
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
