/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import javax.swing.JOptionPane;

/**
 * Modal Helper.
 *
 * @author raulsm
 */
public class Dialog {

    public static void info(String message, String title) {
        custom(message, title, JOptionPane.INFORMATION_MESSAGE);
    }

    public static void error(String message, String title) {
        custom(message, title, JOptionPane.ERROR_MESSAGE);
    }
    
    public static void warning(String message, String title) {
        custom(message, title, JOptionPane.WARNING_MESSAGE);
    }

    /**
     * Brings up a dialog that displays a message using a default icon
     * determined by the <code>messageType</code> parameter.
     *
     * @param message the <code>Object</code> to display
     * @param title the title string for the dialog
     * @param messageType the type of message to be displayed:
     * <code>ERROR_MESSAGE</code>, <code>INFORMATION_MESSAGE</code>,
     * <code>WARNING_MESSAGE</code>, <code>QUESTION_MESSAGE</code>, or
     * <code>PLAIN_MESSAGE</code>
     */
    public static void custom(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(
                null,
                message,
                title,
                messageType
        );
    }
}
