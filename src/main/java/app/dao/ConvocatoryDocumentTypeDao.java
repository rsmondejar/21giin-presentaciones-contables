/**
 * Convocatory Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.ConvocatoryDocumentType;
import java.util.List;

/**
 * Convocatory Document Type DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class ConvocatoryDocumentTypeDao extends BaseDao {

    /**
     * Convocatory Document Type DAO Constructor.
     */
    public ConvocatoryDocumentTypeDao() {
        super.setModel(new ConvocatoryDocumentType());
    }

    /**
     * List Convocatories Documents Types.
     *
     * @return List of Documents Types
     */
    @Override
    public List<ConvocatoryDocumentType> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return ConvocatoryDocumentType
     */
    @Override
    public ConvocatoryDocumentType findById(int id) {
        return super.findById(id);
    }

    /**
     * Create Convocatory Document Type.
     *
     * @param <T> Class
     * @param convocatoryDocumentType Convocatory Document Type
     * @return status
     */
    public <T> Integer create(ConvocatoryDocumentType convocatoryDocumentType) {
        return super.create((BaseEntity) convocatoryDocumentType);
    }

    /**
     * Update Convocatory Document Type.
     *
     * @param <T> T
     * @param id Identifier
     * @param convocatoryDocumentType Document Type
     * @return Status
     */
    public <T> boolean update(int id, ConvocatoryDocumentType convocatoryDocumentType) {
        return super.update(id, (BaseEntity) convocatoryDocumentType);
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
