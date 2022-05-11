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
}
