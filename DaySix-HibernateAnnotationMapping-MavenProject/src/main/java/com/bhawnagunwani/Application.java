package com.bhawnagunwani;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.bhawnagunwani.models.Student;

public class Application {

	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		
		Student student1 = new Student();
		student1.setFirstName("King");
		student1.setLastName("Kochhar");
		student1.setEmail("king.kochhar@gmail.com");
		
		Student student2 = new Student();
		student2.setFirstName("John");
		student2.setLastName("Smith");
		student2.setEmail("john.smith@gmail.com");
		
		session.save(student1);
		session.save(student2);
		
		tran.commit();
		System.out.println("Student inserted Successfully..");
		factory.close();
		session.close();
	}
	
}
