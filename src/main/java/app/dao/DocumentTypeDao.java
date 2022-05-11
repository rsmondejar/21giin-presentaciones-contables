/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import static app.dao.BaseDao.model;
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

    static {
        model = (BaseEntity) new DocumentType();
    }

    /**
     * List Documents Types.
     *
     * @return List of Documents Types
     */
    public static List<DocumentType> all() {
        return BaseDao.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return DocumentType
     */
    public static DocumentType findById(int id) {
        return BaseDao.findById(id);
    }

    /**
     * Create Document Type.
     *
     * @param <T>
     * @param documentType Document Type
     * @return status
     */
    public static <T> Integer create(DocumentType documentType) {
        return BaseDao.create((BaseEntity) documentType);
    }

    /**
     * Update Document Type.
     *
     * @param <T>
     * @param id Identifier
     * @param documentType Document Type
     * @return
     */
    public static <T> boolean update(int id, DocumentType documentType) {
        return BaseDao.update(id, (BaseEntity) documentType);
    }

    /**
     * Delete Document Type.
     *
     * @param id Identifier
     * @return status
     */
    public static boolean delete(int id) {
        return BaseDao.delete(id);
    }
}
