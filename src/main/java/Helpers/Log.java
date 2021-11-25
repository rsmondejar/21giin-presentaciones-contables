/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helpers;

import java.util.Arrays;

/**
 * Log Helper.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class Log {

    public static void error(Exception exception) {
        System.out.println("❌ Error: " + exception.getMessage());
        System.out.println(Arrays.toString(exception.getStackTrace()));
        System.out.println("==========================");
    }

    public static void info(String text) {
        System.out.println("💡 INFO: " + text);
    }

    public static void success(String text) {
        System.out.println("🎉 SUCCESS: " + text);
    }

    public static void warning(String text) {
        System.out.println("❗ WARNING: " + text);
    }
}
