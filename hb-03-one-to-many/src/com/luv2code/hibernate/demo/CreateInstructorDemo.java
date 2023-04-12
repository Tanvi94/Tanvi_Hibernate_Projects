package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateInstructorDemo {

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

			// create the objects

			//Instructor tempInstructor =
					//new Instructor("Chad", "Darby", "darby@luv2code.com");

			//InstructorDetail tempInstructorDetail =
					//new InstructorDetail(
							//"http://www.luv2code.com/youtube",
							//"Luv 2 code!!!");

			Instructor tempInstructor =
					new Instructor("Garima", "Dabir", "dabirGarmima2@gmail.com");

			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.garima217.com/youtube",
							"Reading");
			//associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			//start the session
			session.beginTransaction();
			session.save(tempInstructor);
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





