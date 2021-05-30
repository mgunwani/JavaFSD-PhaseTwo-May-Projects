package com.bhawnagunwani;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bhawnagunwani.models.Student;
import com.bhawnagunwani.utils.HibernateUtil;

public class Demo {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtil.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Student student1 = new Student();
			student1.setFirstName("Sarah");
			student1.setLastName("Bowling");
			student1.setEmail("sarah.bowling@gmail.com");
			
			session.save(student1);
			transaction.commit();
			
		} catch(Exception ex) {
			if(transaction != null) 
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

}
