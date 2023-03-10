package com.rahil.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.rahil.hibernate.demo.entity.Course;
import com.rahil.hibernate.demo.entity.Instructor;
import com.rahil.hibernate.demo.entity.InstructorDetail;
import com.rahil.hibernate.demo.entity.Review;
import com.rahil.hibernate.demo.entity.Student;


public class AddCoursesForMaryDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
								
				
		
		
		// create session
		Session session = factory.getCurrentSession();
		
		
		try {


			// start a transaction
			session.beginTransaction();
			
			// get the student Doe from the database
			int theId = 2;
			Student tempStudent = session.get(Student.class, theId);
			
			System.out.println("\nLoaded student: " + tempStudent);
			System.out.println("Course: " + tempStudent.getCourses());
			
			// create more courses
			Course tempCourse1 = new Course("Java");
			Course tempCourse2 = new Course("Spring Framework");
			
			// add student to courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// save the courses
			System.out.println("\nSaving the courses ...");
			session.save(tempCourse1);
			session.save(tempCourse2);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");

			}
		finally {
			// add clean up code
			session.close();
			
			factory.close();
		}
		
		
		
		
		
		
		
		
		
		
		

	}

}
