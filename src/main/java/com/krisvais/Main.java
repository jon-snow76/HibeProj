package com.krisvais;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Student s1 = new Student();
        System.out.println(s1);
        s1.setSname("krishna");
        s1.setRollno(123);
        s1.setSage(103);


        Configuration cfg = new Configuration();
        //In order to persist the class
//        cfg.addAnnotatedClass(com.krisvais.Student.class);
//        cfg.configure();

/*Buidling hibernate sessions factory
* */
        SessionFactory sf = new Configuration()
                .addAnnotatedClass(com.krisvais.Student.class)
                .configure()
                .buildSessionFactory();

        Session session = sf.openSession();

//        Transaction transaction = session.beginTransaction();
//        session.persist(s1);
//        transaction.commit();
//        session.close();
//        Student s2 = null;
/*
* we can use merge to either update/ insert rows/cols */
        s1= session.get(Student.class,101);
        Transaction transaction = session.beginTransaction();
        session.remove(s1);
        transaction.commit();
        sf.close();


        System.out.println(s1);

        }
    }