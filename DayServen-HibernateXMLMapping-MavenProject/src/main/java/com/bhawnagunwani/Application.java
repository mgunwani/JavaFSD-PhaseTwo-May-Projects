package com.bhawnagunwani;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bhawnagunwani.models.Category;
import com.bhawnagunwani.utils.HibernateUtils;

public class Application {

	public static void main(String[] args) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			Category category1 = new Category();
			category1.setName("Input Devices");
			
			Category category2 = new Category();
			category2.setName("Output Devices");
			
			session.save(category1);
			session.save(category2);
			
			transaction.commit();
			
		} catch(Exception ex) {
			if(transaction != null) 
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		
	}
	
}
