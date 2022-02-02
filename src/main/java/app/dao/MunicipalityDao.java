/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import static app.dao.BaseDao.model;
import app.entities.BaseEntity;
import app.entities.Municipality;
import java.util.List;

/**
 * Municipality DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MunicipalityDao extends BaseDao {

    static {
        model = (BaseEntity) new Municipality();
    }

    /**
     * List Municipalitys.
     *
     * @return List of Municipalities
     */
    public static List<Municipality> all() {
        return BaseDao.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Municipality
     */
    public static Municipality findById(int id) {
        return BaseDao.findById(id);
    }

    /**
     * Create Municipality.
     *
     * @param <T>
     * @param municipality Municipality
     * @return status
     */
    public static <T> boolean create(Municipality municipality) {
        return BaseDao.create((BaseEntity) municipality);
    }

    /**
     * Update Municipality.
     *
     * @param <T>
     * @param id Identifier
     * @param municipality Municipality
     * @return
     */
    public static <T> boolean update(int id, Municipality municipality) {
        return BaseDao.update(id, (BaseEntity) municipality);
    }

    /**
     * Delete Municipality.
     *
     * @param id Identifier
     * @return status
     */
    public static boolean delete(int id) {
        return BaseDao.delete(id);
    }
}
