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
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;

/**
 * User Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "login", name = "loginUniqueConstraint"))
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "role",
            query = "SELECT ur.* FROM user_roles as ur "
            + " WHERE ur.id = :role_id",
            resultClass = UserRole.class
    ),
    @NamedNativeQuery(
            name = "municipality",
            query = "SELECT m.* FROM municipalities as m "
            + " WHERE m.id = :municipality_id",
            resultClass = Municipality.class
    )
})
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

    @Transient
    private UserRole userRole;

    @Transient
    private Municipality municipality;
    
    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public User() {
    }

    public User(String login, String password, int roleId, int municipalityId) {
        this.setLogin(login);
        this.setPassword(password);
        this.setRoleId(roleId);
        this.setMunicipalityId(municipalityId);
    }
    
    public User(int id, String login, String password, int roleId, int municipalityId) {
        this.setId(id);
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

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public Municipality getMunicipality() {
        return municipality;
    }

    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }
    
    public String getRoleName() {
        return this.getUserRole().getRole();
    }
    
    public String getMunicipalityName() {
        return this.getMunicipality().getName();
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getLogin();
    }
}
