/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.entities;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author raulsm
 */
@Entity(name = "convocatories")
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
    private Timestamp startDate;
    
    @Column(name = "end_date")
    private Timestamp endDate;
 
    @Column(name = "is_valid")
    private Boolean isValid;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Convocatory() {
    }

    public Convocatory(String name, String description, Timestamp startDate, Timestamp endDate, Boolean isValid) {
        this.setName(name);
        this.setDescription(description);
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setIsValid(isValid);
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
    public Timestamp getStartDate() {
        return startDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP"})
    public Timestamp getEndDate() {
        return endDate;
    }

    @SuppressFBWarnings({"EI_EXPOSE_REP2"})
    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Convocatory{" 
                 + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", description=" + this.getDescription()
                + ", startDate=" + this.getStartDate()
                + ", endDate=" + this.getEndDate()
                + ", isValid=" + this.getIsValid()
                + '}';
    }
    
    
}
