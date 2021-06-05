package com.bhawnagunwani;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.bhawnagunwani.models.Brand;
import com.bhawnagunwani.models.Category;
import com.bhawnagunwani.models.Product;
import com.bhawnagunwani.utils.HibernateUtils;

public class OneToManyExample {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		try(Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			
			/*
			Brand brand1 = new Brand("Apple");
			Set<Product> products = new HashSet<Product>();
			products.add(new Product("iPhone 12", 89000, brand1));
			products.add(new Product("iPhone 12 Mini", 79000, brand1));
			products.add(new Product("iPhone 12 Pro", 110000, brand1));
			brand1.setProducts(products);
			session.save(brand1);
			*/
			
			Brand brand2 = new Brand("Samsung");
			Set<Product> products = new HashSet<Product>();
			products.add(new Product("Samsung Galaxy", 89000, brand2));
			products.add(new Product("Samsung Note", 79000, brand2));
			products.add(new Product("Samsung Pro", 110000, brand2));
			brand2.setProducts(products);
			session.save(brand2);
			transaction.commit();
			
		} catch(Exception ex) {
			if(transaction != null) 
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
		
	}

}
