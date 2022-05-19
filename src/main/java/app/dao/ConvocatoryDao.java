/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Convocatory;
import app.entities.ConvocatoryDocumentType;
import app.entities.DocumentType;
import java.util.List;

/**
 * Convocatory DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class ConvocatoryDao extends BaseDao {

    public ConvocatoryDao() {
        super.setModel((BaseEntity) new Convocatory());
    }

    /**
     * List Convocatories.
     *
     * @return List of Convocatories
     */
    @Override
    public List<Convocatory> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Convocatory
     */
    @Override
    public Convocatory findById(int id) {
        
        // Add Documents Types
        Convocatory convocatory = super.findById(id);
        
        // Add documents to entity
        List<DocumentType> documentTypesIds = super
                    .whereNamedQuery("documents_types", "convocatory_id", String.valueOf(id));

        convocatory.setDocumentsTypes(documentTypesIds);
        
        return convocatory;
    }

    /**
     * Create Convocatory.
     *
     * @param <T>
     * @param convocatory Convocatory
     * @return status
     */
    public <T> Integer create(Convocatory convocatory) {
        Integer id = super.create((BaseEntity) convocatory);
        // Create documents types
        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();

        ConvocatoryDocumentTypeDao convocatoryDocumentTypeDao = new ConvocatoryDocumentTypeDao();

        for (DocumentType documentType : documentTypes) {
            ConvocatoryDocumentType convocatoryDocumentType = new ConvocatoryDocumentType(id, documentType.getId());
            convocatoryDocumentTypeDao.create(convocatoryDocumentType);
        }
        
        return id;
    }

    /**
     * Update Convocatory.
     *
     * @param <T>
     * @param id Identifier
     * @param convocatory Convocatory
     * @return
     */
    public <T> boolean update(int id, Convocatory convocatory) {
        boolean status = super.update(id, (BaseEntity) convocatory);
        
        List<DocumentType> documentTypes = convocatory.getDocumentsTypes();
         
        super.executeNamedQuery("delete_documents_types", "convocatory_id", String.valueOf(id));
        
        ConvocatoryDocumentTypeDao convocatoryDocumentTypeDao = new ConvocatoryDocumentTypeDao();

        for (DocumentType documentType : documentTypes) {
            ConvocatoryDocumentType convocatoryDocumentType = new ConvocatoryDocumentType(id, documentType.getId());
            convocatoryDocumentTypeDao.create(convocatoryDocumentType);
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
}
