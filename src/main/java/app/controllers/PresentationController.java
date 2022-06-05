/**
 * Presentation Controller Class.
 */
package app.controllers;

import app.dao.PresentationDao;
import app.entities.Presentation;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 * Presentation Controller Class.
 *
 * @author raulsm
 */
public class PresentationController extends BaseController {

    /**
     * List Presentations.
     *
     * @return List Presentations.
     */
    public static List<Presentation> list() {
        // Get all presentations
        List<Presentation> presentations = (new PresentationDao()).all();

        return presentations;
    }

    /**
     * Find Presentation by Id.
     *
     * @param id Presentation Id
     * @return Status
     */
    public static Presentation findById(int id) {
        Presentation presentation = null;

        try {
            presentation = (new PresentationDao()).findById(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando presentación");
        }

        return presentation;
    }

    /**
     * Find Presentation by Id.
     *
     * @param id Presentation Id
     * @return Status
     */
    public static Presentation edit(int id) {
        Presentation presentation = null;

        try {
            presentation = (new PresentationDao()).findById(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando presentación");
        }

        return presentation;
    }

    /**
     * Create Presentation.
     *
     * @param presentation Presentation
     * @return Status
     */
    public static boolean create(Presentation presentation) {
        boolean status = false;

        try {
            Integer id = (new PresentationDao()).create(presentation);
            status = id != null;
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando presentación");
        }

        return status;
    }

    /**
     * Update Presentation.
     *
     * @param id Presentation Id.
     * @param presentation Presenntation.
     * @return Status
     */
    public static boolean update(int id, Presentation presentation) {
        boolean status = false;

        try {
            status = (new PresentationDao()).update(id, presentation);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando presentación");
        }

        return status;
    }

    /**
     * Delete Presentation.
     *
     * @param id Presentation Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;

        try {
            status = (new PresentationDao()).delete(id);
        } catch (Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando presentación");
        }

        return status;
    }
}
