/**
 * Base Madel.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Base Madel.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class BaseEntity {

    /**
     * id Id.
     */
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected int id;

    /**
     * Get Id.
     *
     * @return Id.
     */
    public int getId() {
        return id;
    }
}
