/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

    public void setModel(BaseEntity model) {
        this.model = model;
    }
    
    public BaseEntity getModel() {
        return this.model;
    }

    /**
     * Get all
     *
     * @param <T> T
     * @return All registers
     */
    public <T> List<T> all() {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();
//            session.beginTransaction();
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
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            T baseEntity = (T) session.find(getModel().getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            return baseEntity;
        } catch (RuntimeException exception) {
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
     * Find by Id.
     *
     * @param <T> T
     * @param id Identifier
     * @return model instance or null
     */
    public <T> List<T> whereNamedQuery(String queryName, String columnName, String columnValue) {
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            Query query = session.getNamedQuery(queryName).setParameter(columnName, columnValue);
            
            List<T> baseEntities = (List<T>) query.getResultList();

            if (baseEntities == null) {
                throw new HibernateException("Registers not found");
            }

            return baseEntities;
        } catch (RuntimeException exception) {
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
