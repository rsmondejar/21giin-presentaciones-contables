/**
 * Convocatory DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Convocatory;
import app.entities.ConvocatoryDocumentType;
import app.entities.DocumentType;
import app.entities.Presentation;
import helpers.Log;
import java.util.List;

/**
 * Convocatory DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class ConvocatoryDao extends BaseDao {

    /**
     * Convocatory DAO Constructor.
     */
    public ConvocatoryDao() {
        super.setModel(new Convocatory());
    }

    /**
     * List Convocatories.
     *
     * @return List of Convocatories
     */
    @Override
    public List<Convocatory> all() {
        List<Convocatory> convocatories = super.all();

        // Add extra field Document Types
        for (int i = 0; i < convocatories.size(); i++) {
            convocatories.set(i, findById(convocatories.get(i).getId()));
        }

        return convocatories;
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Convocatory
     */
    @Override
    public Convocatory findById(int id) {
        return addRelations((Convocatory) super.findById(id));
    }

    /**
     * Create Convocatory.
     *
     * @param <T> T
     * @param convocatory Convocatory
     * @return status
     */
    public <T> Integer create(Convocatory convocatory) {
        Integer id = super.create((BaseEntity) convocatory);
        // Create documents types
        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();

        if (documentTypes != null) {
            ConvocatoryDocumentTypeDao convocatoryDocumentTypeDao = new ConvocatoryDocumentTypeDao();

            for (DocumentType documentType : documentTypes) {
                ConvocatoryDocumentType convocatoryDocumentType = new ConvocatoryDocumentType(id, documentType.getId());
                convocatoryDocumentTypeDao.create(convocatoryDocumentType);
            }
        }

        return id;
    }

    /**
     * Update Convocatory.
     *
     * @param <T> T
     * @param id Identifier
     * @param convocatory Convocatory
     * @return Status
     */
    public <T> boolean update(int id, Convocatory convocatory) {
        boolean status = super.update(id, (BaseEntity) convocatory);

        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();

        super.executeNamedQuery("delete_documents_types", "convocatory_id", String.valueOf(id));

        if (documentTypes != null) {
            ConvocatoryDocumentTypeDao convocatoryDocumentTypeDao = new ConvocatoryDocumentTypeDao();

            for (DocumentType documentType : documentTypes) {
                ConvocatoryDocumentType convocatoryDocumentType = new ConvocatoryDocumentType(id, documentType.getId());
                convocatoryDocumentTypeDao.create(convocatoryDocumentType);
            }
        }

        return status;
    }

    /**
     * Delete Convocatory.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    /**
     * List Active Convocatories.
     *
     * @return List of Convocatories
     */
    public List<Convocatory> active() {
        List<Convocatory> convocatories = super.whereNamedQuery("active", null, null);

        // Add extra field Document Types
        for (int i = 0; i < convocatories.size(); i++) {
            convocatories.set(i, findById(convocatories.get(i).getId()));
        }

        return convocatories;
    }

    /**
     * List No Active Convocatories.
     *
     * @return List of Convocatories
     */
    public List<Convocatory> noActive() {
        List<Convocatory> convocatories = super.whereNamedQuery("no_active", null, null);

        // Add extra field Document Types
        for (int i = 0; i < convocatories.size(); i++) {
            convocatories.set(i, findById(convocatories.get(i).getId()));
        }

        return convocatories;
    }

    /**
     * Add Relations.
     *
     * @param convocatory Convocatory
     * @return Convocatory with relations
     */
    public Convocatory addRelations(Convocatory convocatory) {
        try {
            // Add Documents Types
            List<DocumentType> documentTypes = super
                    .whereNamedQuery("documents_types", "convocatory_id", String.valueOf(convocatory.getId()));

            convocatory.setDocumentsTypes(documentTypes);

            // Add Presentations
            List<Presentation> presentations = super
                    .whereNamedQuery("presentations", "convocatory_id", String.valueOf(convocatory.getId()));

            convocatory.setPresentations(presentations);

            return convocatory;
        } catch (Exception exception) {
            Log.error(exception);
        }

        return null;
    }
}
