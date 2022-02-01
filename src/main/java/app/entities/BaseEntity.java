/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Base Madel
 * @author raulsm
 * @version 1.0.0
 */
abstract class BaseEntity {
    
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    // </editor-fold>
}
