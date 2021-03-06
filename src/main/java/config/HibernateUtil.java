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
            
            // Update configuration with enviroment variables
            if (System.getenv("HIBERNATE_URL") != null) {
                cfg.setProperty("hibernate.connection.url", System.getenv("HIBERNATE_URL"));
            }
            
            if (System.getenv("HIBERNATE_USERNAME") != null) {
                cfg.setProperty("hibernate.connection.username", System.getenv("HIBERNATE_USERNAME"));
            }
            
            if (System.getenv("HIBERNATE_PASSWORD") != null) {
                cfg.setProperty("hibernate.connection.password", System.getenv("HIBERNATE_PASSWORD"));
            }

            sessionFactory = cfg.buildSessionFactory();
        } catch(Exception exception) {
            Log.error(exception);
            throw new ExceptionInInitializerError();
        }
    }
    
    /**
     * Get Session Factory
     * @return Session Factory.
     */
    public static SessionFactory get() {
        return sessionFactory;
    }
}
