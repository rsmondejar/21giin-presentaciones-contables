/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App.Models;

/**
 * User Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
public final class User extends BaseModel {

    private String login;
    private String password;
    private int roleId;
    private int municipalityId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public User() {
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
