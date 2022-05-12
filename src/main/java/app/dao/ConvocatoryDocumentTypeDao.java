/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

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

    public ConvocatoryDocumentTypeDao() {
        super.setModel((BaseEntity) new ConvocatoryDocumentType());
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
     * @param <T>
     * @param convocatoryDocumentType Convocatory Document Type
     * @return status
     */
    public <T> Integer create(ConvocatoryDocumentType convocatoryDocumentType) {
        return super.create((BaseEntity) convocatoryDocumentType);
    }

    /**
     * Update Convocatory Document Type.
     *
     * @param <T>
     * @param id Identifier
     * @param convocatoryDocumentType Document Type
     * @return
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
