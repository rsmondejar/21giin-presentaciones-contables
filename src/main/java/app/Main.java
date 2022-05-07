/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package app;

import app.entities.User;
import helpers.Log;
import app.views.LoginJFrame;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

/**
 *
 * @author raulsm
 */
public class Main {

    private static final LoginJFrame loginPanel = new LoginJFrame();

    private static User authUser;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Log.info("Aplicación iniciada");

        try {           
            // Show login view
            loginPanelShow();
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

    @SuppressFBWarnings({"EI_EXPOSE_STATIC_REP2", "MS_EXPOSE_REP"})
    public static void setAuthUser(User user) {
        authUser = user;
    }

    @SuppressFBWarnings({"MS_EXPOSE_REP"})
    public static User getAuthUser() {
        return authUser;
    }
}
