/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Municipality Category Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "municipality_categories")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "nameUniqueConstraint"))
public class MunicipalityCategory extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public MunicipalityCategory() {
    }

    public MunicipalityCategory(String name) {
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
