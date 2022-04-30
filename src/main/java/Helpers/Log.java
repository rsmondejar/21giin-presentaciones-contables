/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helpers;

import java.util.Arrays;

/**
 * Log Helper.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class Log {

    /**
     * Error message.
     * @param exception Exception
     */
    public static void error(Throwable exception) {
        System.out.println("❌ Error: " + exception.getMessage());
        System.out.println(Arrays.toString(exception.getStackTrace()));
        System.out.println("==========================");
    }

    /**
     * Info message.
     * @param text Text to display
     */
    public static void info(String text) {
        System.out.println("💡 INFO: " + text);
    }

    /**
     * Success message.
     * @param text Text to display
     */
    public static void success(String text) {
        System.out.println("🎉 SUCCESS: " + text);
    }

    /**
     * Warning message.
     * @param text Text to display
     */
    public static void warning(String text) {
        System.out.println("❗ WARNING: " + text);
    }
}
