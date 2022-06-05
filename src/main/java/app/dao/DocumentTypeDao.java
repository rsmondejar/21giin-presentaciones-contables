/**
 * Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.DocumentType;
import java.util.List;

/**
 * Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class DocumentTypeDao extends BaseDao {

    /**
     * Document Type DAO Consructor.
     */
    public DocumentTypeDao() {
        super.setModel(new DocumentType());
    }

    /**
     * List Documents Types.
     *
     * @return List of Documents Types
     */
    @Override
    public List<DocumentType> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return DocumentType
     */
    @Override
    public DocumentType findById(int id) {
        return super.findById(id);
    }

    /**
     * Create Document Type.
     *
     * @param <T> T
     * @param documentType Document Type
     * @return status
     */
    public <T> Integer create(DocumentType documentType) {
        return super.create((BaseEntity) documentType);
    }

    /**
     * Update Document Type.
     *
     * @param <T> T
     * @param id Identifier
     * @param documentType Document Type
     * @return Status
     */
    public <T> boolean update(int id, DocumentType documentType) {
        return super.update(id, (BaseEntity) documentType);
    }

    /**
     * Delete Document Type.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }
}
