/**
 * Municipality Controller Class.
 */
package app.controllers;

import app.dao.MunicipalityDao;
import app.dao.MunicipalityTotalDocumentDao;
import app.entities.Municipality;
import app.entities.MunicipalityTotalDocument;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 * Municipality Controller Class.
 *
 * @author raulsm
 */
public class MunicipalityController extends BaseController {

    /**
     * List Municipies.
     *
     * @return List Municipies
     */
    public static List<Municipality> list() {
        // Get all municipalities
        List<Municipality> municipalities = (new MunicipalityDao()).all();

        return municipalities;
    }

    /**
     * Find Municipality by Id.
     *
     * @param id Municipality Id
     * @return Status
     */
    public static Municipality findById(int id) {
        Municipality municipality = null;

        try {
            municipality = (new MunicipalityDao()).findById(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando municipio");
        }

        return municipality;
    }

    /**
     * Find Municipality by Id.
     *
     * @param id Municipality Id
     * @return Status
     */
    public static Municipality edit(int id) {
        Municipality municipality = null;

        try {
            municipality = (new MunicipalityDao()).findById(id);

            // Load edit view
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando municipio");
        }

        return municipality;
    }

    /**
     * Create Municipality.
     *
     * @param municipality Municipality
     * @return Status
     */
    public static boolean create(Municipality municipality) {
        boolean status = false;

        try {
            Integer id = (new MunicipalityDao()).create(municipality);
            status = id != null;
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando municipio");
        }

        return status;
    }

    /**
     * Update Municipality.
     *
     * @param id Municipality Id.
     * @param municipality Municipality.
     * @return Status
     */
    public static boolean update(int id, Municipality municipality) {
        boolean status = false;

        try {
            status = (new MunicipalityDao()).update(id, municipality);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando municipio");
        }

        return status;
    }

    /**
     * Delete Municipality.
     *
     * @param id Municipality Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;

        try {
            status = (new MunicipalityDao()).delete(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando municipio");
        }

        return status;
    }

    /**
     * Municipalities Presentations Total Documents.
     *
     * @return Municipalities Presentation Total Documents.
     */
    public static List<MunicipalityTotalDocument> municipalitiesPresentationsTotalDocuments() {
        List<MunicipalityTotalDocument> municipalities = null;

        try {
            municipalities = (new MunicipalityTotalDocumentDao()).all();
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error recuperando presentaciones por municipio");
        }

        return municipalities;
    }
}
