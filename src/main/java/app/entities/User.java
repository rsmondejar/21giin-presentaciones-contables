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
 * User Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login", name = "loginUniqueConstraint"))
public class User extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;
    
    @Column(name = "login")
    private String login;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "user_role_id")
    private int roleId;
    
    @Column(name = "municipality_id")
    private int municipalityId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public User() {
    }

    public User(String login, String password, int roleId, int municipalityId) {
        this.setLogin(login);
        this.setPassword(password);
        this.setRoleId(roleId);
        this.setMunicipalityId(municipalityId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getMunicipalityId() {
        return municipalityId;
    }

    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return "User{"
                + "id=" + this.getId()
                + ", login=" + this.getLogin()
                + ", password=" + this.getPassword()
                + ", roleId=" + this.getRoleId()
                + ", municipalityId=" + this.getMunicipalityId()
                + '}';
    }
}
