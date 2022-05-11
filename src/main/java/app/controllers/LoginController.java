/**
 * Login Controller Controller Class
 * @autor raulsm 
 */
package app.controllers;

import app.Main;
import app.dao.UserDao;
import app.entities.User;
import helpers.Dialog;
import helpers.Log;

/**
 * Login Controller.
 *
 * @author raulsm
 */
public class LoginController extends BaseController {

    /**
     * Loggin
     * @param name User Name
     * @param password User Password
     */
    public static void loggin(String name, String password) {

        Boolean isValid = false;

        // Check if user exists in database
        User user = null;
        try {
            user = (new UserDao()).findByLoginAndPassword(name, password);
            isValid = true;
        } catch (Exception exception) {
            Log.error(exception);
        }

        if (!isValid) {
            Dialog.error("Usuario y/o contraseña incorrectos", "Error login");
            return;
        }

        // Store session user
        Main.setAuthUser(user);

        // Hide login view
        Main.loginPanelHide();

        // Show Main Menu
        MainController mainController = new MainController();
        mainController.menuPanelShow();
    }
}
