/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.entities;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Presentation Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "presentations")
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

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Presentation() {
    }

    public Presentation(Date date, Boolean isValid, int convocatoryId) {
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
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
