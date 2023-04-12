package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCoursesDemo {

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
			//Create some courses
			Course tempCourse1 = new Course("Air Guitar - The ultimate guide");
			Course tempCourse2 = new Course("The Pinball Masterclass");
			//add courses to instructor
			tempIns.add(tempCourse1);
			tempIns.add(tempCourse2);
			//save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		}
		finally {
			session.close();
			factory.close();
		}
	}

}





