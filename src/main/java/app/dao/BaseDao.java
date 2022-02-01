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
     * @param <T> T
     * @return All registers
     */
    public static <T> List<T> all() {
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();

            List<T> baseEntities = (List<T>) loadAllData(model.getClass(), session);

            if (baseEntities == null) {
                throw new HibernateException("Registers not found");
            }

            return baseEntities;

        } catch (HibernateException exception) {
            Log.error(exception);
            return null;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
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
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();

            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            return baseEntity;

        } catch (HibernateException exception) {
            Log.error(exception);
            return null;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
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
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();

            session.save(entity);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException exception) {
            Log.error(exception);
            return false;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
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
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();

            // check if exits
            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.merge(entity);

            session.getTransaction().commit();

            return true;
        } catch (HibernateException exception) {
            Log.error(exception);
            return false;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
        }
    }

    /**
     * Delete by Id.
     * 
     * @param <T> T
     * @param id Identifier
     * @return  boolean Status
     */
    public static <T> boolean delete(int id) {
        try {
            Session session = HibernateUtil.get().getCurrentSession();

            session.beginTransaction();

            T baseEntity = (T) session.find(model.getClass(), id);

            if (baseEntity == null) {
                throw new HibernateException("Id [%d] not found".formatted(id));
            }

            session.delete(baseEntity);
            session.getTransaction().commit();

            return true;
        } catch (HibernateException exception) {
            Log.error(exception);
            return false;
        } finally {
            HibernateUtil.get().getCurrentSession().close();
        }
    }

    /**
     * Load All Data.
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
