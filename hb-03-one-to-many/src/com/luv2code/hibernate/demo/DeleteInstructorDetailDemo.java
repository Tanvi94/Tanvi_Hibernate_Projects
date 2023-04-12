package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteInstructorDetailDemo {

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
			//Get the Instructor detail object
			int theId = 4;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class,theId);
			//print the instructor detail
			System.out.println("Instructor Details are:"+tempInstructorDetail);
			//print the associated instructor
			System.out.println("The associated instructor is:"+tempInstructorDetail.getInstructor());
			//remove associated object reference break bi directional link
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
			System.out.println(" Delete Done!!");

		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





