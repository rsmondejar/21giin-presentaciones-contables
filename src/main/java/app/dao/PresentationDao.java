/**
 * Presentation DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Presentation;
import app.entities.Convocatory;
import app.entities.PresentationDocumentType;
import app.entities.User;
import helpers.Log;
import java.util.List;

/**
 * Presentation DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class PresentationDao extends BaseDao {

    /**
     * Presentation DAO Constructor.
     */
    public PresentationDao() {
        super.setModel(new Presentation());
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
     * @param <T> T
     * @param presentation Presentation
     * @return status
     */
    public <T> Integer create(Presentation presentation) {
        Integer id = super.create((BaseEntity) presentation);

        // Create presentation documents types
        List<PresentationDocumentType> presentationDocumentTypes = presentation.getPresentationDocumentTypes();

        if (presentationDocumentTypes != null) {
            PresentationDocumentTypeDao presentationDocumentTypeDao = new PresentationDocumentTypeDao();

            for (PresentationDocumentType presentationDocumentType : presentationDocumentTypes) {
                presentationDocumentType.setPresentationId(id);
                presentationDocumentTypeDao.create(presentationDocumentType);
            }
        }
        return id;
    }

    /**
     * Update Presentation.
     *
     * @param <T> T
     * @param id Identifier
     * @param presentation Presentation
     * @return Status.
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
     * @return Presentation with relations
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

            if (convocatories != null && !convocatories.isEmpty()) {
                presentation.setConvocatory(convocatories.get(0));
            }

            // Add User
            List<User> users = super
                    .whereNamedQuery(
                            "user",
                            "user_id",
                            String.valueOf(presentation.getUserId())
                    );

            if (users != null && !users.isEmpty()) {
                presentation.setUser(users.get(0));
            }

            // Add Documents
            List<PresentationDocumentType> presentationDocumentTypes = super
                    .whereNamedQuery(
                            "documents",
                            "presentation_id",
                            String.valueOf(presentation.getId())
                    );

            presentation.setPresentationDocumentTypes(presentationDocumentTypes);

            return presentation;
        } catch (Exception exception) {
            Log.error(exception);
        }

        return null;
    }
}
