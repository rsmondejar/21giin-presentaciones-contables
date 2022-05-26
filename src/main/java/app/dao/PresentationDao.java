/**
 * Presentation DAO.
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Presentation;
import app.entities.Convocatory;
import helpers.Log;
import java.util.List;

/**
 * Presentation DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class PresentationDao extends BaseDao {

    public PresentationDao() {
        super.setModel((BaseEntity) new Presentation());
    }

    /**
     * List Presentations.
     *
     * @return List of presentations
     */
    public List<Presentation> all() {
        List<Presentation> presentations = super.all();

        // Add extra fields
        for (int i = 0; i < presentations.size(); i++) {
            presentations.set(i, findById(presentations.get(i).getId()));
        }

        return presentations;
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Presentation
     */
    @Override
    public Presentation findById(int id) {
        return addRelations((Presentation) super.findById(id));
    }

    /**
     * Create Presentation.
     *
     * @param <T>
     * @param presentation Presentation
     * @return status
     */
    public <T> Integer create(Presentation presentation) {
        return super.create((BaseEntity) presentation);
    }

    /**
     * Update Presentation.
     *
     * @param <T>
     * @param id Identifier
     * @param presentation Presentation
     * @return
     */
    public <T> boolean update(int id, Presentation presentation) {
        return super.update(id, (BaseEntity) presentation);
    }

    /**
     * Delete Presentation.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    /**
     * Add Relations.
     *
     * @param presentation Presentation
     */
    private Presentation addRelations(Presentation presentation) {
        try {
            // Add Convocatory
            List<Convocatory> convocatories = super
                    .whereNamedQuery(
                            "convocatory",
                            "convocatory_id",
                            String.valueOf(presentation.getConvocatoryId())
                    );

            presentation.setConvocatory(convocatories.get(0));

            return presentation;
        } catch (Exception exception) {
            Log.error(exception);
        }

        return null;
    }
}
