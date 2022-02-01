/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import helpers.Log;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Util Config
 * @author raulsm
 * @version 1.0.0
 */
public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    
    static {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
        } catch(Throwable exception) {
            Log.error(exception);
            throw new ExceptionInInitializerError();
        }
    }
    
    public static SessionFactory get() {
        return sessionFactory;
    }
}
