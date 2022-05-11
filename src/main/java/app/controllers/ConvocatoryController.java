/**
 * Convocatory Controller Class
 */
package app.controllers;

import app.dao.ConvocatoryDao;
import app.dao.ConvocatoryDocumentTypeDao;
import app.entities.Convocatory;
import app.entities.ConvocatoryDocumentType;
import helpers.Dialog;
import helpers.Log;
import java.util.List;

/**
 *
 * @author raulsm
 */
public class ConvocatoryController {
    
    /**
     * List Convocatories.
     * @return 
     */
    public static List<Convocatory> list() {
        // Get all convocatories
        List<Convocatory> convocatories = (new ConvocatoryDao()).all();

        return convocatories;
    }
    
    /**
     * Find Convocatory by Id.
     * @param id Convocatory Id
     * @return Status
     */
    public static Convocatory findById(int id) {
        Convocatory convocatory = null;
        
        try {
            ConvocatoryDao convocatoryDao = new ConvocatoryDao();
            convocatory = convocatoryDao.findById(id);
            
            // @TODO: Add documents
            List<Integer> documentTypesIds = convocatoryDao
                    .whereNamedQuery("find_by_convocatory_id", "convocatory_id", String.valueOf(id));
            
            convocatory.setDocumentsTypes(documentTypesIds);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando convocatoria");
        }
        
        return convocatory;
    }
    
    /**
     * Find Convocatory by Id.
     * @param id Convocatory Id
     * @return Status
     */
    public static Convocatory edit(int id) {
        Convocatory convocatory = null;
        
        try {
            convocatory = (new ConvocatoryDao()).findById(id);            
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error buscando convocatoria");
        }
        
        return convocatory;
    }
    
    /**
     * Create Convocatory.
     * @param convocatory Convocatory
     * @return Status
     */
    public static boolean create(Convocatory convocatory) {
        boolean status = false;
        
        try {
            Integer id = (new ConvocatoryDao()).create(convocatory);
            status = id != null;
            
            // Crear los documentos asociados
            List<Integer> documentTypes = convocatory.getDocumentsTypes();
            
            for(Integer documentType : documentTypes) {
                ConvocatoryDocumentType convocatoryDocumentType = new ConvocatoryDocumentType(id, documentType);
                ConvocatoryDocumentTypeDao.create(convocatoryDocumentType);
            }
            
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error creando convocatoria");
        }
        
        return status;
    }
    
    /**
     * Update Convocatory.
     * @param id Convocatory Id
     * @param convocatory Convocatory
     * @return 
     */
    public static boolean update(int id, Convocatory convocatory) {
        boolean status = false;
        
        try {
            status = (new ConvocatoryDao()).update(id, convocatory);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error actualizando convocatoria");
        }
        
        return status;
    }
    
    /**
     * Delete Convocatory.
     * @param id Convocatory Id
     * @return Status
     */
    public static boolean delete(int id) {
        boolean status = false;
        
        try {
            status = (new ConvocatoryDao()).delete(id);
        } catch(Exception e) {
            Log.error(e);
            Dialog.error(e.getMessage(), "Error eliminando convocatoria");
        }
        
        return status;
    }
}
