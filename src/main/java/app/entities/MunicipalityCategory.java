/**
 * Municipality Category Model.
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
 * Municipality Category Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "municipality_categories")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "nameUniqueConstraint"))
public class MunicipalityCategory extends BaseEntity {

    /**
     * id Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Municipality Category Constructor.
     */
    public MunicipalityCategory() {
    }

    /**
     * Municipality Category Constructor.
     *
     * @param name Name.
     */
    public MunicipalityCategory(String name) {
        this.setName(name);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    /**
     * Get Id.
     *
     * @return Id.
     */
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
     * Get Name.
     *
     * @return Name.
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name.
     *
     * @param name Name.
     */
    public void setName(String name) {
        this.name = name;
    }
    // </editor-fold>

    /**
     * To String.
     *
     * @return Name.
     */
    @Override
    public String toString() {
        return this.getName();
    }
}
