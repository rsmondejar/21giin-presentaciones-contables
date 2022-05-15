/**
 * User Role Controller Class
 */
package app.controllers;

import app.dao.UserRoleDao;
import app.entities.UserRole;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class UserRoleController {
    
    /**
     * List Municipies.
     * @return 
     */
    public static List<UserRole> list() {
        // Get all userRoles
        List<UserRole> userRoles = (new UserRoleDao()).all();

        return userRoles;
    }
    
    /**
     * Find UserRole by Id.
     * @param id UserRole Id
     * @return Status
     */
    public static UserRole findById(int id) {
        UserRole userRole = null;
        
        try {
            userRole = (new UserRoleDao()).findById(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando perfil");
        }
        
        return userRole;
    }
    
    /**
     * Find UserRole by Id.
     * @param id UserRole Id
     * @return Status
     */
    public static UserRole edit(int id) {
        UserRole userRole = null;
        
        try {
            userRole = (new UserRoleDao()).findById(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando perfil");
        }
        
        return userRole;
    }
    
    /**
     * Create UserRole.
     * @param userRole UserRole
     * @return Status
     */
    public static boolean create(UserRole userRole) {
        boolean status = false;
        
        try {
            Integer id = (new UserRoleDao()).create(userRole);
            status = id != null;
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando perfil");
        }
        
        return status;
    }
    
    /**
     * Update UserRole.
     * @param id
     * @param userRole
     * @return 
     */
    public static boolean update(int id, UserRole userRole) {
        boolean status = false;
        
        try {
            status = (new UserRoleDao()).update(id, userRole);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando perfil");
        }
        
        return status;
    }
    
    /**
     * Delete UserRole.
     * @param id UserRole Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;
        
        try {
            status = (new UserRoleDao()).delete(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando perfil");
        }
        
        return status;
    }
}
