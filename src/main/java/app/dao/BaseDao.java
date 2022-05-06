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
    protected static BaseEntity model;

    /**
     * Get all
     *
     * @param <T> T
     * @return All registers
     */
    public static <T> List<T> all() {
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            session.beginTransaction();

            List<T> baseEntities = (List<T>) loadAllData(model.getClass(), session);

            if (baseEntities == null) {
                throw new HibernateException("Registers not found");
            }

            return baseEntities;
        } catch (RuntimeException exception) {
            Log.error(exception);
            return null;
        } finally {
//            session.flush();
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
    public static <T> T findById(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            return baseEntity;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return null;
        } finally {
//            session.flush();
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
    public static <T> boolean create(BaseEntity entity) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return false;
        } finally {
//            session.flush();
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
    public static <T> boolean update(int id, BaseEntity entity) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            // check if exits
            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.merge(entity);

            session.getTransaction().commit();

            return true;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return false;
        } finally {
//            session.flush();
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
    public static <T> boolean delete(int id) {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.delete(baseEntity);
            session.getTransaction().commit();

            return true;
        } catch (RuntimeException exception) {
            if (trns != null) {
                trns.rollback();
            }

            Log.error(exception);
            return false;
        } finally {
//            session.flush();
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
    private static <T> List<T> loadAllData(Class<T> type, Session session) {
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
