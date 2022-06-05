/**
 * User Role DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.UserRole;
import java.util.List;

/**
 * User Role DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class UserRoleDao extends BaseDao {

    /**
     * User Role DAO Constructor.
     */
    public UserRoleDao() {
        super.setModel(new UserRole());
    }

    /**
     * List Users Roles.
     *
     * @return List of users
     */
    public List<UserRole> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return User Role
     */
    @Override
    public UserRole findById(int id) {
        return super.findById(id);
    }

    /**
     * Create User Role.
     *
     * @param <T> T
     * @param userRole User Role
     * @return status
     */
    public <T> Integer create(UserRole userRole) {
        return super.create((BaseEntity) userRole);
    }

    /**
     * Update User Role.
     *
     * @param <T> T
     * @param id Identifier
     * @param userRole User
     * @return Status
     */
    public <T> boolean update(int id, UserRole userRole) {
        return super.update(id, (BaseEntity) userRole);
    }

    /**
     * Delete User Role.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }
}
