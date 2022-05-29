/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.entities;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Transient;

/**
 * Presentation Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "presentations")
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "convocatory",
            query = "SELECT c.* FROM convocatories as c "
            + " WHERE c.id = :convocatory_id",
            resultClass = Municipality.class
    )
})
public class Presentation extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Column(name = "date")
    private Date date;
    
    @Column(name = "is_valid")
    private Boolean isValid;
    
    @Column(name = "convocatory_id")
    private int convocatoryId;
    
    @Column(name = "user_id")
    private int userId;
    
    @Transient
    private Convocatory convocatory;
    
    @Transient
    private List<PresentationDocumentType> presentationDocumentTypes;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Presentation() {
    }

    public Presentation(Date date, Boolean isValid, int convocatoryId) {
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
    }
    
    public Presentation(int id, Date date, Boolean isValid, int convocatoryId, int userId) {
        this.setId(id);
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
        this.setUserId(userId);
    }
    
    public Presentation(
            int id,
            Date date,
            Boolean isValid,
            int convocatoryId,
            int userId,
            List<PresentationDocumentType> presentationDocumentTypes
    ) {
        this.setId(id);
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
        this.setUserId(userId);
        this.setPresentationDocumentTypes(presentationDocumentTypes);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public Date getDate() {
        return date;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setDate(Date date) {
        this.date = date;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public int getConvocatoryId() {
        return convocatoryId;
    }

    public void setConvocatoryId(int convocatoryId) {
        this.convocatoryId = convocatoryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Convocatory getConvocatory() {
        return convocatory;
    }

    public void setConvocatory(Convocatory convocatory) {
        this.convocatory = convocatory;
    }

    public List<PresentationDocumentType> getPresentationDocumentTypes() {
        return presentationDocumentTypes;
    }

    public void setPresentationDocumentTypes(List<PresentationDocumentType> presentationDocumentTypes) {
        this.presentationDocumentTypes = presentationDocumentTypes;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Presentation{"
                + "id=" + this.getId()
                + ", date=" + this.getDate()
                + ", isValid=" + this.getIsValid()
                + ", convocatoryId=" + this.getConvocatoryId()
                + '}';
    }
}
