/**
 * Municality Model.
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
 * Municality Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "municipalities")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "nameUniqueConstraint"))
public class Municipality extends BaseEntity {

    /**
     * id Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private int categoryId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    /**
     * Municipality Constructor.
     */
    public Municipality() {
    }

    /**
     * Municipality Constructor.
     *
     * @param name Name
     * @param categoryId Category Id.
     */
    public Municipality(String name, int categoryId) {
        this.setName(name);
        this.setCategoryId(categoryId);
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

    /**
     * Get Category Id.
     *
     * @return Category Id.
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set Category Id,
     *
     * @param categoryId Category Id.
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
