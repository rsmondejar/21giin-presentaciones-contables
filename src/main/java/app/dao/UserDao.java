/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.User;
import java.util.List;

/**
 * User DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class UserDao extends BaseDao {

    static {
        model = (BaseEntity) new User();
    }

    /**
     * List Users.
     *
     * @return List of users
     */
    public static List<User> all() {
        return BaseDao.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return User
     */
    public static User findById(int id) {
        return BaseDao.findById(id);
    }

    /**
     * Create User.
     *
     * @param <T>
     * @param user User
     * @return status
     */
    public static <T> boolean create(User user) {
        return BaseDao.create((BaseEntity) user);
    }

    /**
     * Update User.
     *
     * @param <T>
     * @param id Identifier
     * @param user User
     * @return
     */
    public static <T> boolean update(int id, User user) {
        return BaseDao.update(id, (BaseEntity) user);
    }

    /**
     * Delete User.
     *
     * @param id Identifier
     * @return status
     */
    public static boolean delete(int id) {
        return BaseDao.delete(id);
    }
}
