package com.tut;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
//		get  , load
		
		Configuration cfg=new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory=cfg.buildSessionFactory();
		
		Session session =factory.openSession();
//		get-studentL:102
		Student student= (Student)session.load(Student.class, 104);
		System.out.println(student);
		
		Address ad=(Address)session.get(Address.class, 2);
		System.out.println(ad.getStreet());
		
		
		factory.close();

	}

}
