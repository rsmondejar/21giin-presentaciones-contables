/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.controllers;

import app.Main;
import app.entities.User;
import app.views.LoginJFrame;
import helpers.Dialog;
import helpers.Log;

/**
 *
 * @author raulsm
 */
public class LoginController extends BaseController {

    public static User loggin(String name, String password) {

        Log.info("Name: " + name + " - Password: " + password);

        // @TODO: "Check if user exists in database"
        Boolean isValid = false;

        // @TODO: remove after connection to database
        if (name.equals("raul") && password.equals("1234")) {
            isValid = true;
        }

        if (!isValid) {
            Dialog.error("Usuario y/o contraseña incorrectos", "Error login");
            return null;
        }

        // @TODO: If OK
        
        // @TODO: Save user "session"
        User user = new User();
        user.setLogin(name);
        user.setPassword(password);
        user.setId(1);
        user.setRoleId(1);
        
        Main.setAuthUser(user);
        
        // @TODO: Hide login view
        Main.loginPanelHide();

        // @TODO: Show Main Menu
        MainController mainController = new MainController();
        
        return null;
    }
}
