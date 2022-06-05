/**
 * Document Type Model.
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
 * Document Type Model.
 *
 * @author raulsm
 * @version 1.0.0
 */
@Entity(name = "documents_types")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "name", name = "nameUniqueConstraint"))
public class DocumentType extends BaseEntity {

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
     * Document Type Constructor.
     */
    public DocumentType() {
    }

    /**
     * Document Type Constructor.
     *
     * @param name Name.
     */
    public DocumentType(String name) {
        this.setName(name);
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
     * Get Name
     *
     * @return Name
     */
    public String getName() {
        return name;
    }

    /**
     * Set Name
     *
     * @param name Name
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
