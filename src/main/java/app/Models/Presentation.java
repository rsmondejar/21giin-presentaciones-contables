/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Models;

import java.util.Date;

/**
 * Presentation Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
public final class Presentation extends BaseModel {

    private Date date;
    private Boolean isValid;
    private int convocatoryId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Presentation() {
    }

    public Presentation(int id, Date date, Boolean isValid, int convocatoryId) {
        this.setId(id);
        this.setDate(date);
        this.setIsValid(isValid);
        this.setConvocatoryId(convocatoryId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public Date getDate() {
        return date;
    }

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
