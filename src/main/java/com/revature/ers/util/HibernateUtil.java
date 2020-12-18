package com.revature.ers.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static SessionFactory sessionFactory = new Configuration().configure("hibernate.config.xml").buildSessionFactory();
    private static Session session;

    public static Session getSession(){
        if(session == null){
            session = sessionFactory.openSession();
        }

        return session;
    }

    public static void closeSession(){
        session.close();
        session = null;
    }
}
