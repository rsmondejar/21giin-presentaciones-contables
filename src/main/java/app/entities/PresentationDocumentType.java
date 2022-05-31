/**
 * Presentation Document Type Model.
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
 * Presentation Document Type Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "presentations_has_documents_types")
@NamedNativeQuery(
        name = "find_by_presentation_id",
        query = "SELECT pdt.* FROM presentations_has_documents_types pdt "
        + "WHERE pdt.presentation_id = :presentation_id"
)
public class PresentationDocumentType extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "presentation_id")
    private int presentationId;

    @Column(name = "document_type_id")
    private int documentTypeId;

    @Column(name = "content")
    private byte[] content;
    
    @Column(name = "file_name")
    private String fileName;
    
    @Column(name = "file_extension")
    private String fileExtension;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Presentation Document Type Constructor.
     */
    public PresentationDocumentType() {
    }

    /**
     * Presentation Document Type Constructor.
     * @param presentationId Presentation Id.
     * @param documentTypeId Document Type Id.
     */
    public PresentationDocumentType(int presentationId, int documentTypeId) {
        this.setPresentationId(presentationId);
        this.setDocumentTypeId(documentTypeId);
    }

    /**
     * Presentation Document Type Constructor.
     * @param id Id.
     * @param presentationId Presentation Id.
     * @param documentTypeId Document Type Id.
     */
    public PresentationDocumentType(int id, int presentationId, int documentTypeId) {
        this.setId(id);
        this.setPresentationId(presentationId);
        this.setDocumentTypeId(documentTypeId);
    }

    /**
     * Presentation Document Type Constructor.
     * @param id Id.
     * @param presentationId Presentation Id.
     * @param documentTypeId Document Type Id.
     * @param content Document Content.
     * @param fileName Document File Name.
     * @param fileExtension Document File Extension.
     */
    public PresentationDocumentType(
            int id, int presentationId,
            int documentTypeId,
            byte[] content,
            String fileName,
            String fileExtension
    ) {
        this.setId(id);
        this.setPresentationId(presentationId);
        this.setDocumentTypeId(documentTypeId);
        this.setContent(content);
        this.setFileName(fileName);
        this.setFileExtension(fileExtension);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPresentationId() {
        return presentationId;
    }

    public void setPresentationId(int presentationId) {
        this.presentationId = presentationId;
    }

    public int getDocumentTypeId() {
        return documentTypeId;
    }

    public void setDocumentTypeId(int documentTypeId) {
        this.documentTypeId = documentTypeId;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }
    // </editor-fold>
    
    @Override
    public String toString() {
        return "ConvocatoryDocumentType{"
                + "id=" + this.getId()
                + ", presentationId=" + this.getPresentationId()
                + ", documentTypeId=" + this.getDocumentTypeId()
                + '}';
    }
}
