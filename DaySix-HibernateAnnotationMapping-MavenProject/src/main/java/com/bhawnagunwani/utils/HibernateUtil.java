package com.bhawnagunwani.utils;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateUtil {

	private static StandardServiceRegistry registery;
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				// Create Registry
				registery = new StandardServiceRegistryBuilder().configure().build();
				// Create MetaDataSources
				MetadataSources sources = new MetadataSources(registery);
				// Create Metadata
				Metadata metadata = sources.getMetadataBuilder().build();
				// Create SessionFactory
				sessionFactory = metadata.getSessionFactoryBuilder().build();
			} catch (Exception ex) {
				if (registery != null) {
					StandardServiceRegistryBuilder.destroy(registery);
				}
			}
		}
		return sessionFactory;
	}
	
	public static void shutdown() {
		if (registery != null) {
			StandardServiceRegistryBuilder.destroy(registery);
		}
	}

}
