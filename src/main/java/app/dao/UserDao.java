/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import static app.dao.BaseDao.model;
import app.entities.BaseEntity;
import app.entities.User;
import config.HibernateUtil;
import helpers.Log;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

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
    public static <T> Integer create(User user) {
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
    
    /**
     * Find By Login And Password.
     * @param login Login
     * @param password Password
     * @return User
     * @throws Exception 
     */
    public static User findByLoginAndPassword(String login, String password) throws Exception {
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();
            
            Query query = session.createQuery("SELECT u FROM users u WHERE u.login=:login AND u.password=:password");
            query.setParameter("login", login);
            query.setParameter("password", password);
            
            User user = (User) query.uniqueResult();
            
            if (user == null) {
                throw new Exception("Not found user with login '%s' and password '%s'".formatted(login, password));
            }

            return user;

        } catch (HibernateException exception) {
            Log.error(exception);
            throw exception;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
        }
    }
}
