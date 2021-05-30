package com.bhawnagunwani;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.bhawnagunwani.models.Answer;
import com.bhawnagunwani.models.Question;

public class OneToManyRelationshipExample {
	
	public static void main(String[] args) {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		SessionFactory factory = meta.getSessionFactoryBuilder().build();
		Session session = factory.openSession();
		Transaction tran = session.beginTransaction();
		
		Answer ans1 = new Answer();
		ans1.setAnswer("Connectivity Architecture");
		ans1.setPostedBy("John");
		
		Answer ans2 = new Answer();
		ans2.setAnswer("Database Connecting Framework");
		ans2.setPostedBy("Smith");
		
		ArrayList<Answer> ansList = new ArrayList<Answer>();
		ansList.add(ans1);
		ansList.add(ans2);
		
		Question question = new Question();
		question.setQuestion("What is JDBC?");
		question.setAnswers(ansList);

		session.save(question);
		
		System.out.println("Question ans its answers posted successfully.");
		
		tran.commit();
		factory.close();
		session.close();
		
	}

}
