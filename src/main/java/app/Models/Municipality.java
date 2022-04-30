/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Models;

/**
 * Municality Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
public final class Municipality extends BaseModel {

    private String name;
    private int categoryId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Municipality() {
    }

    public Municipality(int id, String name, int categoryId) {
        this.setId(id);
        this.setName(name);
        this.setCategoryId(categoryId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "Municipality{"
                + "id=" + this.getId()
                + ", name=" + this.getName()
                + ", categoryId=" + this.getCategoryId()
                + '}';
    }
}
