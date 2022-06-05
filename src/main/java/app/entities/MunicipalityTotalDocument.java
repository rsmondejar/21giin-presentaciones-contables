/**
 * Municipality Total Document View Model.
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

/**
 * Municipality Total Document View Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "municipalities_total_documents_view")
public class MunicipalityTotalDocument extends BaseEntity {

    /**
     * id Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "municipality_name")
    private String municipalityName;

    @Column(name = "total_documents")
    private int totalDocuments;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Municipality Total Document Constructor.
     */
    public MunicipalityTotalDocument() {
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
     * Get Municipality Name.
     *
     * @return Municipality Name.
     */
    public String getMunicipalityName() {
        return municipalityName;
    }

    /**
     * Get Total Documents.
     *
     * @return Total Documents.
     */
    public int getTotalDocuments() {
        return totalDocuments;
    }
    // </editor-fold>
}
