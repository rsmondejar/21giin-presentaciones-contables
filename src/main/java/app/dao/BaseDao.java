/**
 * Base DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import config.HibernateUtil;
import helpers.Log;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import app.entities.BaseEntity;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Base DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
class BaseDao {

    /**
     * BaseEntity model
     */
    protected BaseEntity model;

    /**
     * Set Model.
     *
     * @param model Model.
     */
    public void setModel(BaseEntity model) {
        this.model = model;
    }

    /**
     * Get Model.
     *
     * @return Model.
     */
    public BaseEntity getModel() {
        return this.model;
    }

    /**
     * Get all.
     *
     * @param <T> T
     * @return All registers
     */
    public <T> List<T> all() {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();
            List<T> baseEntities = (List<T>) loadAllData(getModel().getClass(), session);

            if (baseEntities == null) {
                throw new HibernateException("Registers not found");
            }

            trns.commit();

            return baseEntities;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }
            Log.error(exception);
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Find by Id.
     *
     * @param <T> T
     * @param id Identifier
     * @return model instance or null
     */
    public <T> T findById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();
            T baseEntity = (T) session.find(getModel().getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            trns.commit();

            return baseEntity;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }
            Log.error(exception);
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Create model.
     *
     * @param <T> T
     * @param entity Model Entity
     * @return boolean
     */
    public <T> Integer create(BaseEntity entity) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            session.save(entity);
            trns.commit();

            return entity.getId();
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Update model.
     *
     * @param <T> T
     * @param id Identifier
     * @param entity Model Entity
     * @return boolean Status
     */
    public <T> boolean update(int id, BaseEntity entity) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            // check if exits
            T baseEntity = (T) session.find(getModel().getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.merge(entity);
            trns.commit();

            return true;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Delete by Id.
     *
     * @param <T> T
     * @param id Identifier
     * @return boolean Status
     */
    public <T> boolean delete(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            T baseEntity = (T) session.find(getModel().getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.delete(baseEntity);
            trns.commit();

            return true;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return false;
        } finally {
            session.close();
        }
    }

    /**
     * Find by Named Query.
     *
     * @param <T> T
     * @param queryName Query Name
     * @param columnName Column Name
     * @param columnValue Column Value
     * @return List
     */
    public <T> List<T> whereNamedQuery(String queryName, String columnName, String columnValue) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            Query query = session.getNamedQuery(queryName);

            if (columnName != null && columnValue != null) {
                query.setParameter(columnName, columnValue);
            }

            List<T> baseEntities = (List<T>) query.getResultList();

            trns.commit();

            return baseEntities;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }
            Log.error(exception);
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Execute Named Query.
     *
     * @param queryName Query Name
     * @param columnName Column Name
     * @param columnValue Column Value
     * @return Status
     */
    public Integer executeNamedQuery(String queryName, String columnName, String columnValue) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            Query query = session.getNamedQuery(queryName).setParameter(columnName, columnValue);

            int status = query.executeUpdate();

            trns.commit();

            return status;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }
            Log.error(exception);
            return null;
        } finally {
            session.close();
        }
    }

    /**
     * Load All Data.
     *
     * @param <T> Class
     * @param type Type
     * @param session Session
     * @return List of rows
     */
    private <T> List<T> loadAllData(Class<T> type, Session session) {
        try {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery<T> criteria = builder.createQuery(type);
            criteria.from(type);
            List<T> data = session.createQuery(criteria).getResultList();
            return data;
        } catch (Exception exception) {
            Log.error(exception);
            throw exception;
        }
    }
}
