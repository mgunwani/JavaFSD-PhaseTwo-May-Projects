package com.bhawnagunwani;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.type.StringType;

import com.bhawnagunwani.models.Brand;
import com.bhawnagunwani.models.Product;
import com.bhawnagunwani.utils.HibernateUtils;

public class NativeSQLQueriesExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();

			// To retrieve all columns..
			/*
			List<Object[]> brands = session.createNativeQuery("SELECT * FROM brands").list();
			for (Object[] objects : brands) {
				Brand brand = new Brand();
				brand.setId((Integer) objects[0]);
				brand.setName((String) objects[1]);
				System.out.println(brand);
			}*/
			
			/* Mapping Native Query to Entity..*/
			/*
			List<Brand> brands = session.createNativeQuery("SELECT * FROM brands", Brand.class).list();
			for (Brand brand : brands) {
				System.out.println(brand);
			}
			*/

			// To retrieve custom columns list (Projection)..
			/*
			List<Object[]> brands = session.createNativeQuery("SELECT * FROM brands")
					.addScalar("name", StringType.INSTANCE).list();
			for (Object[] objects : brands) {
				Brand brand = new Brand();
				brand.setName((String) objects[0]);
				System.out.println(brand.getName());
			}
			*/
			
			/*
			List<Object[]> result = session.createNativeQuery("SELECT p.name as ProductName, p.price as ProductPrice, b.name as BrandName FROM products p inner join brands b on p.brand_id = b.id;").list();
			for (Object[] objects : result) {
				String productName = (String)objects[0];
				float productPrice = (Float)objects[1];
				String brandName = (String)objects[2];
				System.out.println(productName + " : " + productPrice + " : " + brandName);
			}
			*/
			
			List<Brand> brands = session.createNativeQuery("SELECT * FROM brands where name like :brandName")
					.addEntity(Brand.class).setParameter("brandName", "S%").list();
			for (Brand brand : brands) {
				System.out.println(brand);
			}
			
			

			transaction.commit();

		} catch (Exception ex) {
			if (transaction != null)
				transaction.rollback();
			System.out.println(ex.getMessage());
		}
	}

}
