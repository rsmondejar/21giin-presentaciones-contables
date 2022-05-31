/**
 * Convocatory Model.
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
 * Convocatory Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "convocatories")
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "active",
            query = "SELECT c.* FROM convocatories c "
            + " WHERE c.is_valid = 1 AND c.start_date <= CURRENT_DATE AND c.end_date >= CURRENT_DATE ",
            resultClass = Convocatory.class
    ),
    @NamedNativeQuery(
            name = "no_active",
            query = "SELECT c.* FROM convocatories c "
            + " WHERE c.is_valid = 0 AND c.start_date > CURRENT_DATE || c.end_date < CURRENT_DATE ",
            resultClass = Convocatory.class
    ),
    @NamedNativeQuery(
            name = "documents_types",
            query = "SELECT dt.* FROM documents_types as dt "
            + " JOIN convocatories_has_documents_types cdt ON cdt.document_type_id = dt.id "
            + " WHERE cdt.convocatory_id = :convocatory_id",
            resultClass = DocumentType.class
    ),
    @NamedNativeQuery(
            name = "presentations",
            query = "SELECT p.* FROM presentations p "
            + " WHERE p.is_valid = 1 AND p.convocatory_id = :convocatory_id ",
            resultClass = Presentation.class
    ),
    @NamedNativeQuery(
            name = "delete_documents_types",
            query = "DELETE FROM convocatories_has_documents_types WHERE convocatory_id = :convocatory_id"
    )
})
public class Convocatory extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "is_valid")
    private Boolean isValid;

    @Transient
    private List<DocumentType> documentsTypes;
    
    @Transient
    private List<Presentation> presentations;
    
    @Transient
    private int totalPresentations;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Convocatory() {
    }

    public Convocatory(String name, String description, Date startDate, Date endDate, Boolean isValid) {
        this.setName(name);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setIsValid(isValid);
    }

    public Convocatory(String name, String description, Date startDate, Date endDate, Boolean isValid, List<DocumentType> documentsTypes) {
        this.setName(name);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setIsValid(isValid);
        this.setDocumentsTypes(documentsTypes);
    }

    public Convocatory(int id, String name, String description, Date startDate, Date endDate, Boolean isValid, List<DocumentType> documentsTypes) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setIsValid(isValid);
        this.setDocumentsTypes(documentsTypes);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public Date getStartDate() {
        return startDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public Date getEndDate() {
        return endDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    public List<DocumentType> getDocumentsTypes() {
        return documentsTypes;
    }

    public void setDocumentsTypes(List<DocumentType> documentsTypes) {
        this.documentsTypes = documentsTypes;
    }

    public List<Presentation> getPresentations() {
        return presentations;
    }

    public void setPresentations(List<Presentation> presentations) {
        this.presentations = presentations;
    }

    public int getTotalPresentations() {
        if (this.getPresentations() == null) {
            return 0;
        }
        return this.getPresentations().size();
    }    
    // </editor-fold>

    @Override
    public String toString() {
        return this.getName();
    }
}
