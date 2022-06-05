/**
 * User Model.
 *
 * @author raulsm
 * @version 1.0.0
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

    /**
     * id Id.
     */
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
    /**
     * User Constructor.
     */
    public User() {
    }

    /**
     * User Constructor.
     *
     * @param login Login.
     * @param password Password.
     * @param roleId Role Id.
     * @param municipalityId Municipality Id.
     */
    public User(String login, String password, int roleId, int municipalityId) {
        this.setLogin(login);
        this.setPassword(password);
        this.setRoleId(roleId);
        this.setMunicipalityId(municipalityId);
    }

    /**
     * User Constructor.
     *
     * @param id Id.
     * @param login Login.
     * @param password Password.
     * @param roleId Role Id.
     * @param municipalityId Municipality Id.
     */
    public User(int id, String login, String password, int roleId, int municipalityId) {
        this.setId(id);
        this.setLogin(login);
        this.setPassword(password);
        this.setRoleId(roleId);
        this.setMunicipalityId(municipalityId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    /**
     * Get Id.
     *
     * @return Id.
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set Id.
     *
     * @param id Id.
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get Login.
     *
     * @return Login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Set Login.
     *
     * @param login Login.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Get Password.
     *
     * @return Password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Set Password.
     *
     * @param password Password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Get Role Id.
     *
     * @return Role Id.
     */
    public int getRoleId() {
        return roleId;
    }

    /**
     * Set Role Id.
     *
     * @param roleId Role Id.
     */
    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    /**
     * Get Municipality Id.
     *
     * @return Municipality Id.
     */
    public int getMunicipalityId() {
        return municipalityId;
    }

    /**
     * Set Municipality Id.
     *
     * @param municipalityId Municipality Id.
     */
    public void setMunicipalityId(int municipalityId) {
        this.municipalityId = municipalityId;
    }

    /**
     * Get User Role.
     *
     * @return User Role.
     */
    public UserRole getUserRole() {
        return userRole;
    }

    /**
     * Set User Role.
     *
     * @param userRole User Role.
     */
    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    /**
     * Get Muncipality.
     *
     * @return Municipality.
     */
    public Municipality getMunicipality() {
        return municipality;
    }

    /**
     * Set Municipality.
     *
     * @param municipality Municipality.
     */
    public void setMunicipality(Municipality municipality) {
        this.municipality = municipality;
    }

    /**
     * Get Role Name.
     *
     * @return Role Name.
     */
    public String getRoleName() {
        return this.getUserRole().getRole();
    }

    /**
     * Get Municipality Name.
     *
     * @return Municipality Name.
     */
    public String getMunicipalityName() {
        return this.getMunicipality().getName();
    }
    // </editor-fold>

    /**
     * To String.
     *
     * @return Login
     */
    @Override
    public String toString() {
        return this.getLogin();
    }
}
