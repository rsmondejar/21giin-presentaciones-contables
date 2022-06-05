/**
 * Presentation Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.PresentationDocumentType;

/**
 * Presentation Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class PresentationDocumentTypeDao extends BaseDao {

    /**
     * Presentation Document Type DAO.
     */
    public PresentationDocumentTypeDao() {
        super.setModel(new PresentationDocumentType());
    }

    /**
     * Create Presentation Document Type.
     *
     * @param presentationDocumentType Presentation Document Type
     * @return status
     */
    public Integer create(PresentationDocumentType presentationDocumentType) {
        return super.create((BaseEntity) presentationDocumentType);
    }

    /**
     * Update Presentation Document Type.
     *
     * @param id Identifier
     * @param presentationDocumentType Presentation Document Type
     * @return Status.
     */
    public boolean update(int id, PresentationDocumentType presentationDocumentType) {
        return super.update(id, (BaseEntity) presentationDocumentType);
    }
}
