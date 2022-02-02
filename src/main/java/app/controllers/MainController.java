/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    private static MenuJFrame menuPanel = new MenuJFrame();

    public MainController() {

        // Get user info
        User authUser = Main.getAuthUser();

        System.out.println(authUser.toString());

        menuPanel.setUserFooterInfo(authUser);

        // Open Menu
        menuPanelShow();

    }

    /**
     * Menu Panel Show.
     */
    public static void menuPanelShow() {
        menuPanel.setLocationRelativeTo(null);
        menuPanel.setVisible(true);
    }

    /**
     * Menu Panel Hide.
     */
    public static void menuPanelHide() {
        menuPanel.setVisible(false);
    }

}
