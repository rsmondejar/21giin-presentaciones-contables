/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import java.sql.Connection;

/**
 *
 * @author raulsm
 */
interface DatabaseConnectorInterface{

    public Connection connection = null;
    public static String driver = null;
    public static String host = null;
    public static String user = null;
    public static String password = null;
    public static String databaseName = null;
    public static String url = null;

    public abstract void connector();
    // public abstract void connector(String url, String user, String password);
}
