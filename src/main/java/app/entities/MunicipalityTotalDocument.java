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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Column(name = "municipality_name")
    private String municipalityName;
    
    @Column(name = "total_documents")
    private int totalDocuments;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MunicipalityTotalDocument() {
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getMunicipalityName() {
        return municipalityName;
    }

    public void setMunicipalityName(String municipalityName) {
        this.municipalityName = municipalityName;
    }

    public int getTotalDocuments() {
        return totalDocuments;
    }

    public void setTotalDocuments(int totalDocuments) {
        this.totalDocuments = totalDocuments;
    }
    // </editor-fold>
}
