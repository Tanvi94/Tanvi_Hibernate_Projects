package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteDemo {

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
			//start the session
			session.beginTransaction();
			int theId = 3;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			System.out.println("Found Instructor: "+tempInstructor);
			if (tempInstructor != null) {
				System.out.println("Deleting: "+tempInstructor);
			}
			//Note: Will also delete associated instructor_detail object
			session.delete(tempInstructor);
			session.getTransaction().commit();
			System.out.println("Done!!");

		}
		finally {
			factory.close();
		}
	}

}





