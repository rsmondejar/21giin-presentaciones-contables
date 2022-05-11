/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

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

    public MunicipalityDao() {
        super.setModel((BaseEntity) new Municipality());
    }

    /**
     * List Municipalitys.
     *
     * @return List of Municipalities
     */
    public List<Municipality> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Municipality
     */
    public Municipality findById(int id) {
        return (new BaseDao()).findById(id);
    }

    /**
     * Create Municipality.
     *
     * @param <T>
     * @param municipality Municipality
     * @return status
     */
    public <T> Integer create(Municipality municipality) {
        return (new BaseDao()).create((BaseEntity) municipality);
    }

    /**
     * Update Municipality.
     *
     * @param <T>
     * @param id Identifier
     * @param municipality Municipality
     * @return
     */
    public <T> boolean update(int id, Municipality municipality) {
        return (new BaseDao()).update(id, (BaseEntity) municipality);
    }

    /**
     * Delete Municipality.
     *
     * @param id Identifier
     * @return status
     */
    public boolean delete(int id) {
        return (new BaseDao()).delete(id);
    }
}
