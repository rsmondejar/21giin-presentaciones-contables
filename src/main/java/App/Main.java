/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package App;

//import Helpers.Dialog;

import Core.DatabaseConnector;
import Core.MySqlDatabaseConnector;
import Helpers.Log;

/**
 *
 * @author raulsm
 */
public class Main {

    public static DatabaseConnector dbConnector;
    
    // TODO: Insertar en fichero de variables
    private static String host = "21giin.rsmondejar.com";
    private static String databaseName = "21giin_presentaciones_digitales_contables";
    private static String user = "dig_cont_admin";
    private static String password = "!z9fRr72";
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Log.info("Aplicación iniciada");
        
//        Dialog.info("Mensaje a pintar", "Mi Título");
//        Dialog.warning("Mensaje a pintar", "Mi Título");
//        Dialog.error("Mensaje a pintar", "Mi Título");

        // TODO: Test connection        
        try {
            dbConnector = (DatabaseConnector) new MySqlDatabaseConnector(host, user, password,databaseName);
            dbConnector.connector();
            
            Log.success("Conexión realizada correctamente");
            
        } catch (Exception exception) {
            Log.error(exception);
        }
    }
}
