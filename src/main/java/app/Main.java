/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

//import Helpers.Dialog;
import app.entities.User;
import config.HibernateUtil;
import helpers.Log;
import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.MetadataSources;
//import org.hibernate.boot.registry.StandardServiceRegistry;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import app.views.LoginJFrame;

/**
 *
 * @author raulsm
 */
public class Main {

    private static LoginJFrame loginPanel = new LoginJFrame();
    
    private static User authUser;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Log.info("Aplicación iniciada");

        try {
//            Session session = HibernateUtil.get().openSession();
            
            Log.success("Conexión realizada correctamente");
            
            // @TODO: Show login view
            loginPanelShow();

            // TODO: Cerrar la sesión al salir del programa
            // session.close();            
            // Log.success("Aplicación finalizada");

        } catch (Exception exception) {
            Log.error(exception);
        }
    }
    
    public static void loginPanelShow() {
        loginPanel.setLocationRelativeTo(null);
        loginPanel.setVisible(true); 
    }
    
    public static void loginPanelHide() {
        loginPanel.setVisible(false); 
    }
    
    public static void setAuthUser(User user) {
        authUser = user;
    }
    
    public static User getAuthUser() {
        return authUser;
    }
}
