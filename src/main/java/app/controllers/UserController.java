/**
 * User Controller Class
 */
package app.controllers;

import app.dao.UserDao;
import app.entities.User;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class UserController extends BaseController {
    
    /**
     * List Users.
     * @return 
     */
    public static List<User> list() {
        // Get all municipalities
        List<User> users = (new UserDao()).all();

        return users;
    }
    
    /**
     * Find User by Id.
     * @param id User Id
     * @return User
     */
    public static User findById(int id) {
        User user = null;
        
        try {
            user = (new UserDao()).findById(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando usuario");
        }
        
        return user;
    }
    
    /**
     * Find User by Id.
     * @param id User Id
     * @return User
     */
    public static User edit(int id) {
        User user = null;
        
        try {
            user = (new UserDao()).findById(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando usuario");
        }
        
        return user;
    }
    
    /**
     * Create User.
     * @param user User
     * @return Status
     */
    public static boolean create(User user) {
        boolean status = false;
        
        try {
            Integer id = (new UserDao()).create(user);
            status = id != null;
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando usuario");
        }
        
        return status;
    }
    
    /**
     * Update User.
     * @param id User Id
     * @param user User
     * @return 
     */
    public static boolean update(int id, User user) {
        boolean status = false;
        
        try {
            status = (new UserDao()).update(id, user);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando usuario");
        }
        
        return status;
    }
    
    /**
     * Delete User.
     * @param id User Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;
        
        try {
            status = (new UserDao()).delete(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando usuario");
        }
        
        return status;
    }
}
