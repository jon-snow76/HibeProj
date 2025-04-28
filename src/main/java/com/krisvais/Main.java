package com.krisvais;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Laptop l1 = new Laptop();
        l1.setLid(1);
        l1.setBrand("Asus");
        l1.setModel("ROG");
        l1.setRam(32);


        Alien a1 = new Alien();
        a1.setAid(101);
        a1.setAname("Vaish");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(com.krisvais.Alien.class)
                .addAnnotatedClass(com.krisvais.Laptop.class)
                .buildSessionFactory();

        Session session =sf.openSession();

        Transaction transaction =session.beginTransaction();
        session.persist(l1);
        session.persist(a1);
        transaction.commit();

        Alien a2 = session.get(Alien.class,101);
                System.out.println(a2);
            session.close();
            sf.close();
        }
    }