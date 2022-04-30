/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Models;

/**
 * Municipality Category Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
public final class MunicipalityCategory extends BaseModel {

    private String name;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MunicipalityCategory() {
    }

    public MunicipalityCategory(int id, String name) {
        this.setId(id);
        this.setName(name);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "MunicipalityCategory{"
                + "id=" + this.getId()
                + ", name=" + this.getName()
                + '}';
    }
}
