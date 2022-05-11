/**
 * Municipality Controller Class
 */
package app.controllers;

import app.dao.MunicipalityDao;
import app.entities.Municipality;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class MunicipalityController {
    
    /**
     * List Municipies.
     * @return 
     */
    public static List<Municipality> list() {
        // Get all municipalities
        List<Municipality> municipalities = MunicipalityDao.all();

        return municipalities;
    }
    
    /**
     * Find Municipality by Id.
     * @param id Municipality Id
     * @return Status
     */
    public static Municipality findById(int id) {
        Municipality municipality = null;
        
        try {
            municipality = MunicipalityDao.findById(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando municipio");
        }
        
        return municipality;
    }
    
    /**
     * Find Municipality by Id.
     * @param id Municipality Id
     * @return Status
     */
    public static Municipality edit(int id) {
        Municipality municipality = null;
        
        try {
            municipality = MunicipalityDao.findById(id);
            
            // Load edit view
            
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando municipio");
        }
        
        return municipality;
    }
    
    /**
     * Create Municipality.
     * @param municipality Municipality
     * @return Status
     */
    public static boolean create(Municipality municipality) {
        boolean status = false;
        
        try {
            status = MunicipalityDao.create(municipality);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando municipio");
        }
        
        return status;
    }
    
    /**
     * Update Municipality.
     * @param id
     * @param municipality
     * @return 
     */
    public static boolean update(int id, Municipality municipality) {
        boolean status = false;
        
        try {
            status = MunicipalityDao.update(id, municipality);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando municipio");
        }
        
        return status;
    }
    
    /**
     * Delete Municipality.
     * @param id Municipality Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;
        
        try {
            status = MunicipalityDao.delete(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando municipio");
        }
        
        return status;
    }
}
