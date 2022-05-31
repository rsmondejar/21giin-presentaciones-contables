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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "convocatory_id")
    private int convocatoryId;

    @Column(name = "document_type_id")
    private int documentTypeId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public ConvocatoryDocumentType() {
    }

    public ConvocatoryDocumentType(int convocatoryId, int documentTypeId) {
        this.setConvocatoryId(convocatoryId);
        this.setDocumentTypeId(documentTypeId);
    }

    public ConvocatoryDocumentType(int id, int convocatoryId, int documentTypeId) {
        this.setId(id);
        this.setConvocatoryId(convocatoryId);
        this.setDocumentTypeId(documentTypeId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getConvocatoryId() {
        return convocatoryId;
    }

    public void setConvocatoryId(int convocatoryId) {
        this.convocatoryId = convocatoryId;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "ConvocatoryDocumentType{"
                + "id=" + this.getId()
                + ", convocatoryId=" + this.getConvocatoryId()
                + ", documentTypeId=" + this.getDocumentTypeId()
                + '}';
    }
}
