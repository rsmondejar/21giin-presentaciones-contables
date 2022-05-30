/**
 * Main Controller Class
 */
package app.controllers;

import app.Main;
import app.entities.User;
import app.views.MenuJFrame;

/**
 *
 * @author raulsm
 */
public class MainController extends BaseController {

    private static final MenuJFrame MENU_PANEL = new MenuJFrame();

    /**
     * Main Controller constructor
     */
    public MainController() {
        // Get user info
        User authUser = Main.getAuthUser();

        System.out.println(authUser.toString());

        MENU_PANEL.setUserFooterInfo(authUser);
        
        // Open Menu
//        menuPanelShow();
    }

    /**
     * Menu Panel Show.
     */
    public void menuPanelShow() {
        MENU_PANEL.setLocationRelativeTo(null);
        MENU_PANEL.setVisible(true);
    }

    /**
     * Menu Panel Hide.
     */
    public void menuPanelHide() {
        MENU_PANEL.setVisible(false);
    }
}
