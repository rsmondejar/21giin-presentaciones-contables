/**
 * User Role Model.
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
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * User Role Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "user_roles")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "role", name = "roleUniqueConstraint"))
public class UserRole extends BaseEntity {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "role")
    private String role;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public UserRole() {
    }

    public UserRole(String role) {
        this.setRole(role);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getRole();
    }
}
