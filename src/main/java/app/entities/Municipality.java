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

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    @Column(name = "name")
    private String name;

    @Column(name = "category_id")
    private int categoryId;

    // <editor-fold defaultstate="collapsed" desc="Constructors">
    public Municipality() {
    }

    public Municipality(String name, int categoryId) {
        this.setName(name);
        this.setCategoryId(categoryId);
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Getters And Setters">
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    // </editor-fold>

    @Override
    public String toString() {
        return this.getName();
    }
}
