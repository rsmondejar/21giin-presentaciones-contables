/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package config;

import helpers.Log;
import java.io.File;
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
            File hibernateFileConfig = new File("hibernate.cfg.xml");
            
            Configuration cfg = new Configuration();
            
            cfg.configure(hibernateFileConfig);
            
            // TODO: update with env variables
            System.out.println("===============================");
            System.out.println("HIBERNATE VARIABLES");
            
            if (System.getenv("HIBERNATE_URL") != null) {
                System.out.println("HIBERNATE_URL CAMBIAR!!!");
                cfg.setProperty("connection.url", System.getenv("HIBERNATE_URL"));
            } else {
                System.out.println("HIBERNATE_URL NO SE HA CAMBIADO!!!");
            }
            
            if (System.getenv("HIBERNATE_USERNAME") != null) {
                System.out.println("HIBERNATE_USERNAME CAMBIAR!!!");
                cfg.setProperty("connection.username", System.getenv("HIBERNATE_USERNAME"));
            } else {
                System.out.println("HIBERNATE_USERNAME NO SE HA CAMBIADO!!!");
            }
            
            if (System.getenv("HIBERNATE_PASSWORD") != null) {
                System.out.println("HIBERNATE_PASSWORD CAMBIAR!!!");
                cfg.setProperty("connection.password", System.getenv("HIBERNATE_PASSWORD"));
            } else {
                System.out.println("HIBERNATE_PASSWORD NO SE HA CAMBIADO!!!");
            }
            
            System.out.println("===============================");
            System.out.println("HIBERNATE_URL: " + System.getenv("HIBERNATE_URL"));
            System.out.println("HIBERNATE_USERNAME: " + System.getenv("HIBERNATE_USERNAME"));
            System.out.println("HIBERNATE_PASSWORD: " + System.getenv("HIBERNATE_PASSWORD"));
            System.out.println("===============================");
            System.out.println("connection.url: " + cfg.getProperty("connection.url"));
            System.out.println("connection.username: " + cfg.getProperty("connection.username"));
            System.out.println("connection.password: " + cfg.getProperty("connection.password"));
            
            System.out.println("===============================");
            
            sessionFactory = cfg.buildSessionFactory();
            
            // @TODO: Remove after testing
            System.out.println(sessionFactory);
        } catch(Throwable exception) {
            Log.error(exception);
            throw new ExceptionInInitializerError();
        }
    }
    
    public static SessionFactory get() {
        return sessionFactory;
    }
}
