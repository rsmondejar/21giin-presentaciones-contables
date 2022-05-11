/**
 * Main Class
 * @autor raulsm
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

    /**
     * Login Panel JFrame
     */
    private static final LoginJFrame LOGIN_PANEL = new LoginJFrame();

    /**
     * Auth User
     */
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

    /**
     * Login Panel Show
     */
    public static void loginPanelShow() {
        LOGIN_PANEL.setLocationRelativeTo(null);
        LOGIN_PANEL.setVisible(true);
    }

    /**
     * Login Panel Hide
     */
    public static void loginPanelHide() {
        LOGIN_PANEL.setVisible(false);
    }

    /**
     * Set Auth User
     * @param user User
     */
    @SuppressFBWarnings({"EI_EXPOSE_STATIC_REP2", "MS_EXPOSE_REP"})
    public static void setAuthUser(User user) {
        authUser = user;
    }

    /**
     * Get Auth User
     * @return Auth User
     */
    @SuppressFBWarnings({"MS_EXPOSE_REP"})
    public static User getAuthUser() {
        return authUser;
    }
}
