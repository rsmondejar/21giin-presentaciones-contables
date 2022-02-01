/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core;

import helpers.Log;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author raulsm
 */
public abstract class DatabaseConnector implements DatabaseConnectorInterface {

    public Connection connection = null;
    public static String driver = null;
    public static String host = null;
    public static String user = null;
    public static String password = null;
    public static String databaseName = null;
    public static String url = null;

    /**
     * MySQL Database Connector Constructor.
     *
     * @param host Database Host
     * @param user Database User Name
     * @param password Database User Password
     * @param databaseName Database Name
     */
    public DatabaseConnector(String host, String user, String password, String databaseName) {

        DatabaseConnector.host = host;
        DatabaseConnector.user = user;
        DatabaseConnector.password = password;
        DatabaseConnector.databaseName = databaseName;
    }

    @Override
    public void connector() {
        try {
            Class.forName(driver);
            connection = (Connection) DriverManager.getConnection(url, user, password);

            if (connection == null) {
                System.out.println("Error database connetion");
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            Log.error(throwables);

        }
    }
}
