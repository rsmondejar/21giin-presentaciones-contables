/**
 * Presentation Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.PresentationDocumentType;
import java.util.List;

/**
 * Presentation Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class PresentationDocumentTypeDao extends BaseDao {

    public PresentationDocumentTypeDao() {
        super.setModel((BaseEntity) new PresentationDocumentType());
    }

    /**
     * List Presentation Documents Types.
     *
     * @return List of Documents Types
     */
    @Override
    public List<PresentationDocumentType> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return PresentationDocumentType
     */
    @Override
    public PresentationDocumentType findById(int id) {
        return super.findById(id);
    }

    /**
     * Create Presentation Document Type.
     *
     * @param <T>
     * @param presentationDocumentType Presentation Document Type
     * @return status
     */
    public <T> Integer create(PresentationDocumentType presentationDocumentType) {
        return super.create((BaseEntity) presentationDocumentType);
    }

    /**
     * Update Presentation Document Type.
     *
     * @param <T>
     * @param id Identifier
     * @param presentationDocumentType Presentation Document Type
     * @return
     */
    public <T> boolean update(int id, PresentationDocumentType presentationDocumentType) {
        return super.update(id, (BaseEntity) presentationDocumentType);
    }

    /**
     * Delete Presentation Document Type.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }
}
