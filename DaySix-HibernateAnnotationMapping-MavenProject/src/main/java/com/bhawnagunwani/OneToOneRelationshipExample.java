package com.bhawnagunwani;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.bhawnagunwani.models.Instructor;
import com.bhawnagunwani.models.InstructorDetail;

public class OneToOneRelationshipExample {
	
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		
		InstructorDetail instructorDetail = new InstructorDetail();
		instructorDetail.setExperience("12 Years");
		instructorDetail.setTechnology("Software Development");
		
		Instructor instructor = new Instructor();
		instructor.setFirstName("Bhawna");
		instructor.setLastName("Gunwani");
		instructor.setEmail("bhawna@gmail.com");
		instructor.setInstructorDetail(instructorDetail);
		
		session.save(instructor);
		
		System.out.println("Instructor and InstructDetails saved Successfully..");
		tran.commit();
		factory.close();
		session.close();
		
	}

}
