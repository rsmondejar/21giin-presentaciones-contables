/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import static app.dao.BaseDao.model;
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

    static {
        model = (BaseEntity) new Convocatory();
    }

    /**
     * List Convocatories.
     *
     * @return List of Convocatories
     */
    public static List<Convocatory> all() {
        return BaseDao.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Convocatory
     */
    public static Convocatory findById(int id) {
        return BaseDao.findById(id);
    }

    /**
     * Create Convocatory.
     *
     * @param <T>
     * @param convocatory Convocatory
     * @return status
     */
    public static <T> Integer create(Convocatory convocatory) {
        return BaseDao.create((BaseEntity) convocatory);
    }

    /**
     * Update Convocatory.
     *
     * @param <T>
     * @param id Identifier
     * @param convocatory Convocatory
     * @return
     */
    public static <T> boolean update(int id, Convocatory convocatory) {
        return BaseDao.update(id, (BaseEntity) convocatory);
    }

    /**
     * Delete Convocatory.
     *
     * @param id Identifier
     * @return status
     */
    public static boolean delete(int id) {
        return BaseDao.delete(id);
    }
}
