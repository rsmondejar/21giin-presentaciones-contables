/**
 * Convocatory Document Type Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;

/**
 * Convocatory Document Type Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "convocatories_has_documents_types")
@NamedNativeQuery(
        name = "find_by_convocatory_id",
        query = "SELECT cdt.* FROM convocatories_has_documents_types cdt "
        + "WHERE cdt.convocatory_id = :convocatory_id"
)
public class ConvocatoryDocumentType extends BaseEntity {

    /**
     * id Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "convocatory_id")
    private int convocatoryId;

    @Column(name = "document_type_id")
    private int documentTypeId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Convocatory Document Type Constructor.
     */
    public ConvocatoryDocumentType() {
    }

    /**
     * Convocatory Document Type Constructor.
     *
     * @param convocatoryId Convocatory Id.
     * @param documentTypeId Document Type Id.
     */
    public ConvocatoryDocumentType(int convocatoryId, int documentTypeId) {
        this.setConvocatoryId(convocatoryId);
        this.setDocumentTypeId(documentTypeId);
    }

    /**
     * Convocatory Document Type Constructor.
     *
     * @param id Id.
     * @param convocatoryId Convocatory Id.
     * @param documentTypeId Document Type Id.
     */
    public ConvocatoryDocumentType(int id, int convocatoryId, int documentTypeId) {
        this.setId(id);
        this.setConvocatoryId(convocatoryId);
        this.setDocumentTypeId(documentTypeId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    /**
     * Get Id.
     *
     * @return Id.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set Id.
     *
     * @param id Id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Convocatory Id.
     *
     * @return Convocatory Id.
     */
    public int getConvocatoryId() {
        return convocatoryId;
    }

    /**
     * Set Convocatory Id.
     *
     * @param convocatoryId Convocatory Id.
     */
    public void setConvocatoryId(int convocatoryId) {
        this.convocatoryId = convocatoryId;
    }

    /**
     * Get Document Type Id.
     *
     * @return Document Type Id.
     */
    public int getDocumentTypeId() {
        return documentTypeId;
    }

    /**
     * Set Document Type Id.
     *
     * @param documentTypeId Document Type Id.
     */
    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
    // </editor-fold>

    /**
     * To String
     *
     * @return String
     */
    @Override
    public String toString() {
        return "ConvocatoryDocumentType{"
                + "id=" + this.getId()
                + ", convocatoryId=" + this.getConvocatoryId()
                + ", documentTypeId=" + this.getDocumentTypeId()
                + '}';
    }
}
