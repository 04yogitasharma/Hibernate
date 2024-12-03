package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import jakarta.transaction.Transaction;

public class EmDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Configuration config=new Configuration();
		config.configure("hibernate.cfg.xml");
		SessionFactory factory=config.buildSessionFactory();
		
		Student student1=new Student();
		student1.setId(1234);
		student1.setName("Vikas Sharma");
		student1.setCity("Mumbai");
		
		Certificate certificate=new Certificate();
		certificate.setCourse("Android");
		certificate.setDuration("2 months");
		student1.setCerti(certificate);
		
		
		Student student2=new Student();
		student2.setId(232);
		student2.setName("Aaksh Sharma");
		student2.setCity("Delhi");
		
		Certificate certificate1=new Certificate();
		certificate1.setCourse("Java");
		certificate1.setDuration("1.5 months");
		student2.setCerti(certificate1);
		
		
		Session s=factory.openSession();
		org.hibernate.Transaction tx=s.beginTransaction();
		
		
//		object save
		s.save(student1);
		s.save(student2);
		
		
		tx.commit();
		s.close();
		factory.close();
		
	}

}
