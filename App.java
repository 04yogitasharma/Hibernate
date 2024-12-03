package com.tut;

import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Project Starting..." );
        
        Configuration cfg=new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory=cfg.buildSessionFactory();
        
        //creating student
        Student st=new Student();
        st.setId(104);
        st.setName("Yogita");
        st.setCity("Bhopal");
       
        System.out.println(st);
        
        Address ad=new Address();
        ad.setStreet("street3");
        ad.setCity("Bhopal");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(54321.4321);
        
        FileInputStream fis=new FileInputStream("src/main/java/0N7A1672.JPG");
        byte[] data=new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        Session session=factory.openSession();
        
        Transaction tx= session.beginTransaction();
        
        session.save(st);
        session.save(ad);
//        session.getTransaction();
//        instead of this we use 
        tx.commit();
        System.out.println("Done.................");
        
        
        session.close();
        
//        System.out.println(factory);
//        System.out.println(factory.isClosed());
        
    }
}
