/**
 * Presentation Model.
 *
 * @author raulsm
 * @version 1.0.0
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
            resultClass = Convocatory.class
    ),
    @NamedNativeQuery(
            name = "user",
            query = "SELECT u.* FROM users as u "
            + " WHERE u.id = :user_id",
            resultClass = User.class
    ),
    @NamedNativeQuery(
            name = "documents",
            query = "SELECT pdt.* FROM presentations_has_documents_types as pdt "
            + " WHERE pdt.presentation_id = :presentation_id",
            resultClass = PresentationDocumentType.class
    ),})
public class Presentation extends BaseEntity {

    /**
     * id Id.
     */
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
    private User user;

    @Transient
    private List<PresentationDocumentType> presentationDocumentTypes;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Presentation Constructor.
     */
    public Presentation() {
    }

    /**
     * Presentation Constructor.
     *
     * @param date Date.
     * @param isValid Is Valid.
     * @param convocatoryId Convocatory Id.
     */
    public Presentation(Date date, Boolean isValid, int convocatoryId) {
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
    }

    /**
     * Presentation Constructor.
     *
     * @param id Id.
     * @param date Date.
     * @param isValid Is Valid.
     * @param convocatoryId Convocatory Id.
     * @param userId User Id.
     */
    public Presentation(int id, Date date, Boolean isValid, int convocatoryId, int userId) {
        this.setId(id);
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
        this.setUserId(userId);
    }

    /**
     * Presentation Constructor.
     *
     * @param id Id.
     * @param date Date.
     * @param isValid Is Valid.
     * @param convocatoryId Convocatory Id.
     * @param userId User Id.
     * @param presentationDocumentTypes Presentation Document Types.
     */
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
     * Get Date.
     *
     * @return Date.
     */
    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public Date getDate() {
        return date;
    }

    /**
     * Set Date.
     *
     * @param date Date.
     */
    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Get Is valid?.
     *
     * @return Is Valid?
     */
    public Boolean getIsValid() {
        return isValid;
    }

    /**
     * Set Is Valid?
     *
     * @param isValid Is Valid?
     */
    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
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
     * Get User Id.
     *
     * @return User Id.
     */
    public int getUserId() {
        return userId;
    }

    /**
     * Set User Id.
     *
     * @param userId User Id.
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * Get Convocatory.
     *
     * @return Convocatory.
     */
    public Convocatory getConvocatory() {
        return convocatory;
    }

    /**
     * Set Convocatory.
     *
     * @param convocatory Convocatory.
     */
    public void setConvocatory(Convocatory convocatory) {
        this.convocatory = convocatory;
    }

    /**
     * Get User.
     *
     * @return User.
     */
    public User getUser() {
        return user;
    }

    /**
     * Set User.
     *
     * @param user User.
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Get Presentation Documents Types.
     *
     * @return Presentation Documents Types.
     */
    public List<PresentationDocumentType> getPresentationDocumentTypes() {
        return presentationDocumentTypes;
    }

    /**
     * Set Presentation Documents Types.
     *
     * @param presentationDocumentTypes Presentation Documents Types.
     */
    public void setPresentationDocumentTypes(List<PresentationDocumentType> presentationDocumentTypes) {
        this.presentationDocumentTypes = presentationDocumentTypes;
    }
    // </editor-fold>

    /**
     * To String
     *
     * @return String.
     */
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
