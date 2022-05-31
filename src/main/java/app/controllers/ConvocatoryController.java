/**
 * Convocatory Controller Class.
 */
package app.controllers;

import app.dao.ConvocatoryDao;
import app.entities.Convocatory;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 * ConvocatoryController.
 *
 * @author raulsm
 */
public class ConvocatoryController extends BaseController {

    /**
     * List Convocatories.
     *
     * @return
     */
    public static List<Convocatory> list() {
        // Get all convocatories
        return (new ConvocatoryDao()).all();
    }

    /**
     * Find Convocatory by Id.
     *
     * @param id Convocatory Id
     * @return Status
     */
    public static Convocatory findById(int id) {
        Convocatory convocatory = null;

        try {
            ConvocatoryDao convocatoryDao = new ConvocatoryDao();
            convocatory = convocatoryDao.findById(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando convocatoria");
        }

        return convocatory;
    }

    /**
     * Find Convocatory by Id.
     *
     * @param id Convocatory Id
     * @return Status
     */
    public static Convocatory edit(int id) {
        Convocatory convocatory = null;

        try {
            convocatory = (new ConvocatoryDao()).findById(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando convocatoria");
        }

        return convocatory;
    }

    /**
     * Create Convocatory.
     *
     * @param convocatory Convocatory
     * @return Status
     */
    public static boolean create(Convocatory convocatory) {
        boolean status = false;

        try {
            Integer id = (new ConvocatoryDao()).create(convocatory);
            status = id != null;
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando convocatoria");
        }

        return status;
    }

    /**
     * Update Convocatory.
     *
     * @param id Convocatory Id
     * @param convocatory Convocatory
     * @return
     */
    public static boolean update(int id, Convocatory convocatory) {
        boolean status = false;

        try {
            status = (new ConvocatoryDao()).update(id, convocatory);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando convocatoria");
        }

        return status;
    }

    /**
     * Delete Convocatory.
     *
     * @param id Convocatory Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;

        try {
            status = (new ConvocatoryDao()).delete(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando convocatoria");
        }

        return status;
    }

    /**
     * List Active Convocatories.
     *
     * @return List of Active Convocatories
     */
    public static List<Convocatory> active() {
        // Get all active convocatories
        return (new ConvocatoryDao()).active();
    }
    
    /**
     * List No Active Convocatories.
     *
     * @return List of No Active Convocatories
     */
    public static List<Convocatory> noActive() {
        // Get all no active convocatories
        return (new ConvocatoryDao()).noActive();
    }
}
