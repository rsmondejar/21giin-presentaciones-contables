/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.DocumentType;
import java.util.List;

/**
 * Municipality DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class DocumentTypeDao extends BaseDao {

    public DocumentTypeDao() {
        super.setModel((BaseEntity) new DocumentType());
    }

    /**
     * List Documents Types.
     *
     * @return List of Documents Types
     */
    public List<DocumentType> all() {
        return (new BaseDao()).all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return DocumentType
     */
    public DocumentType findById(int id) {
        return (new BaseDao()).findById(id);
    }

    /**
     * Create Document Type.
     *
     * @param <T>
     * @param documentType Document Type
     * @return status
     */
    public <T> Integer create(DocumentType documentType) {
        return (new BaseDao()).create((BaseEntity) documentType);
    }

    /**
     * Update Document Type.
     *
     * @param <T>
     * @param id Identifier
     * @param documentType Document Type
     * @return
     */
    public <T> boolean update(int id, DocumentType documentType) {
        return (new BaseDao()).update(id, (BaseEntity) documentType);
    }

    /**
     * Delete Document Type.
     *
     * @param id Identifier
     * @return status
     */
    public boolean delete(int id) {
        return (new BaseDao()).delete(id);
    }
}
