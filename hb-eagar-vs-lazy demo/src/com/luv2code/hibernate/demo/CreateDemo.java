package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



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

			//Instructor tempInstructor =
					//new Instructor("Chad", "Darby", "darby@luv2code.com");

			//InstructorDetail tempInstructorDetail =
					//new InstructorDetail(
							//"http://www.luv2code.com/youtube",
							//"Luv 2 code!!!");

			Instructor tempInstructor =
					new Instructor("Mugdha", "Madhekar", "mugdha27009@gmail.com");

			InstructorDetail tempInstructorDetail =
					new InstructorDetail(
							"http://www.mugdhaguitar.com/youtube",
							"Guitar");
			//associate the object
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			//start the session
			session.beginTransaction();
			//save the object
			//it will also save the details object due to CascadeType.ALL
			System.out.println("Saving Instructor: "+tempInstructor);
			session.save(tempInstructor);
			//commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!!");

		}
		finally {
			factory.close();
		}
	}

}





