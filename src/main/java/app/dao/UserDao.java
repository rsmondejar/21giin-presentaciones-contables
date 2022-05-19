/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Municipality;
import app.entities.User;
import app.entities.UserRole;
import config.HibernateUtil;
import helpers.Log;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * User DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class UserDao extends BaseDao {

    public UserDao() {
        super.setModel((BaseEntity) new User());
    }

    /**
     * List Users.
     *
     * @return List of users
     */
    public List<User> all() {
        List<User> users = super.all();
        
        // Add extra fields: Municpality and UserRole
        for(int i = 0; i < users.size(); i++) {
            users.set(i, findById(users.get(i).getId()));
        }
        
        return users;
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return User
     */
    @Override
    public User findById(int id) {
        return addRelations((User) super.findById(id));
    }

    /**
     * Create User.
     *
     * @param <T>
     * @param user User
     * @return status
     */
    public <T> Integer create(User user) {
        return super.create((BaseEntity) user);
    }

    /**
     * Update User.
     *
     * @param <T>
     * @param id Identifier
     * @param user User
     * @return
     */
    public <T> boolean update(int id, User user) {
        return super.update(id, (BaseEntity) user);
    }

    /**
     * Delete User.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }
    
    /**
     * Find By Login And Password.
     * @param login Login
     * @param password Password
     * @return User
     * @throws Exception 
     */
    public User findByLoginAndPassword(String login, String password) throws Exception {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();
        
        try {
            trns = session.beginTransaction();
            
            Query query = session.createQuery("SELECT u FROM users u WHERE u.login=:login AND u.password=:password");
            query.setParameter("login", login);
            query.setParameter("password", password);
            
            User user = (User) query.uniqueResult();
            
            if (user == null) {
                throw new Exception("Not found user with login '%s' and password '%s'".formatted(login, password));
            }
            
            trns.commit();

            return addRelations(user);
        } catch (HibernateException exception) {
            if (trns != null) {
                trns.rollback();
            }
            Log.error(exception);
            throw exception;
        } finally {
            session.close();
        }
    }
    
    /**
     * Add Relations.
     * @param user User
     */ 
    private User addRelations(User user) {
        try {
            // Add Role
            List<UserRole> userRoles = super
                        .whereNamedQuery("role", "role_id", String.valueOf(user.getRoleId()));

            user.setUserRole(userRoles.get(0));

            // Add Municipality
            List<Municipality> municipalities = super
                        .whereNamedQuery("municipality", "municipality_id", String.valueOf(user.getMunicipalityId()));

            user.setMunicipality(municipalities.get(0));

            return user;
        } catch(Exception exception) {
            Log.error(exception);
        }
        
        return null;
    }
}
