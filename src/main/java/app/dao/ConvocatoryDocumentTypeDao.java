/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import static app.dao.BaseDao.model;
import app.entities.BaseEntity;
import app.entities.ConvocatoryDocumentType;
import java.util.List;

/**
 * Municipality DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class ConvocatoryDocumentTypeDao extends BaseDao {

    static {
        model = (BaseEntity) new ConvocatoryDocumentType();
    }

    /**
     * List Convocatories Documents Types.
     *
     * @return List of Documents Types
     */
    public static List<ConvocatoryDocumentType> all() {
        return BaseDao.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return ConvocatoryDocumentType
     */
    public static ConvocatoryDocumentType findById(int id) {
        return BaseDao.findById(id);
    }

    /**
     * Create Convocatory Document Type.
     *
     * @param <T>
     * @param convocatoryDocumentType Convocatory Document Type
     * @return status
     */
    public static <T> Integer create(ConvocatoryDocumentType convocatoryDocumentType) {
        return BaseDao.create((BaseEntity) convocatoryDocumentType);
    }

    /**
     * Update Convocatory Document Type.
     *
     * @param <T>
     * @param id Identifier
     * @param convocatoryDocumentType Document Type
     * @return
     */
    public static <T> boolean update(int id, ConvocatoryDocumentType convocatoryDocumentType) {
        return BaseDao.update(id, (BaseEntity) convocatoryDocumentType);
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
