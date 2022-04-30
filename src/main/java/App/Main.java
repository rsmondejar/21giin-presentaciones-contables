/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

//import Helpers.Dialog;
import app.dao.UserDao;
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
import helpers.RandomString;
import java.util.List;
import javax.persistence.Entity;
import seeders.UserSeeder;

/**
 *
 * @author raulsm
 */
public class Main {

    private static LoginJFrame loginPanel = new LoginJFrame();

    private static User authUser;

    private static Session session;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Log.info("Aplicación iniciada");

        try {
            session = HibernateUtil.get().openSession();

            Log.success("Conexión realizada correctamente");

            // @TODO: Test Create User
//             UserSeeder.create(10);
            
            // @TODO: Test Find User
//            User user = UserDao.findById(10);
//            Log.success(user.toString());

            // @TODO: Test Remove User
//            boolean statusDelete = UserDao.delete(20);
//            Log.info(String.valueOf(statusDelete));

            // @TODO: Test Find User
//            int userId = 11;
//            User user = UserDao.findById(userId);
//            if (user == null) {
//                throw new Exception("User with id [%d] not found".formatted(userId));
//            }
//            Log.info(user.toString());

            // @TODO: Test Update User
//            int userId = 11;
//            User user = UserDao.findById(userId);
//            if (user == null) {
//                throw new Exception("User with id [%d] not found".formatted(userId));
//            }
//            Log.info(user.toString());
//
//            String loginPrevious = user.getLogin();
//            String passwordPrevious = user.getPassword();
//            
//            user.setLogin("prueba1234");
//            user.setPassword("pasword");
//    
//            boolean statusUpdate = UserDao.update(userId, user);      
//            Log.info(String.valueOf(statusUpdate));
//            
//            user.setLogin(loginPrevious);
//            user.setPassword(passwordPrevious);
//    
//            statusUpdate = UserDao.update(userId, user);      
//            Log.info(String.valueOf(statusUpdate));
            
            // @TODO: Search all users
//            List<User> users = UserDao.all();
//            for (User user : users) {
//                Log.info(String.valueOf(user));
//            }

            
            
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
