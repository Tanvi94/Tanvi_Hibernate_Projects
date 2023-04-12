package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class GetInstructorCoursesDemo {

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

			//start the session
			session.beginTransaction();
			//get the instructor from DB
			int theId = 1;
			Instructor tempIns = session.get(Instructor.class,theId);

			System.out.println("Instructor: "+tempIns);
			//get the course for the Instructor
			System.out.println("Courses for the instructor are: "+tempIns.getCourseList());
			session.getTransaction().commit();
			System.out.println("Done!!");

		}
		finally {
			session.close();
			factory.close();
		}
	}

}





