/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Core;

/**
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MySqlDatabaseConnector extends DatabaseConnector{
    
    public static String mysqlDriver = "com.mysql.cj.jdbc.Driver";

    /**
     * MySQL Database Connector Constructor.
     * @param host Database Host
     * @param user Database User Name
     * @param password Database User Password
     * @param databaseName Database Name
     */
    public MySqlDatabaseConnector(
            String host,
            String user,
            String password,
            String databaseName
    ) {
        super(host, user, password, databaseName);
        url = "jdbc:mysql://" + host + "/" + databaseName;
        
        MySqlDatabaseConnector.driver = mysqlDriver;
    }
}
