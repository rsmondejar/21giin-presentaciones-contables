/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Convocatory;
import java.util.List;

/**
 * Convocatory DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class ConvocatoryDao extends BaseDao {

    public ConvocatoryDao() {
        super.setModel((BaseEntity) new Convocatory());
    }

    /**
     * List Convocatories.
     *
     * @return List of Convocatories
     */
    public List<Convocatory> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Convocatory
     */
    public Convocatory findById(int id) {
        return super.findById(id);
    }

    /**
     * Create Convocatory.
     *
     * @param <T>
     * @param convocatory Convocatory
     * @return status
     */
    public <T> Integer create(Convocatory convocatory) {
        return super.create((BaseEntity) convocatory);
    }

    /**
     * Update Convocatory.
     *
     * @param <T>
     * @param id Identifier
     * @param convocatory Convocatory
     * @return
     */
    public <T> boolean update(int id, Convocatory convocatory) {
        return super.update(id, (BaseEntity) convocatory);
    }

    /**
     * Delete Convocatory.
     *
     * @param id Identifier
     * @return status
     */
    public boolean delete(int id) {
        return super.delete(id);
    }
}
