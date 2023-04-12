package com.luv2code.hibernate.demo;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


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

			//start the session
			session.beginTransaction();
			//get the instructor from DB
			int theId = 1;
			//option 2: Hibernate query with HQL
			Query<Instructor> query = session.createQuery("select i from Instructor i "
														+ "JOIN FETCH i.courseList "
														+ "where i.id=:theInstructorId", Instructor.class);

			//set the parameter on query
			query.setParameter("theInstructorId",theId);
			Instructor tempIns = query.getSingleResult();
			System.out.println("Tanvi 1: Instructor: "+tempIns);
			session.getTransaction().commit();
			//Close the session
			session.close();
			System.out.println("Tanvi 2: Session is closed now...");
			System.out.println("Tanvi 3: Courses are: "+tempIns.getCourseList());
			//option 1: To use lazy loading after session close we need to call getter method while session is open before session.close()

			System.out.println("Done!!");

		}
		finally {
			session.close();
			factory.close();
		}
	}

}





