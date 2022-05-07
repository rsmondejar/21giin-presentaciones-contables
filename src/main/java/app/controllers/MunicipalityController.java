/**
 * Municipality Controller Class
 */
package app.controllers;

import app.dao.MunicipalityDao;
import app.entities.Municipality;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class MunicipalityController {
    
    /**
     * List Municipies
     * @return 
     */
    public static List<Municipality> list() {
        // Get all municipalities
        List<Municipality> municipalities = MunicipalityDao.all();

        return municipalities;
    }
}
