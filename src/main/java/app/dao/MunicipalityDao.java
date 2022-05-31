/**
 * Municipality DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.Municipality;
import config.HibernateUtil;
import helpers.Log;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 * Municipality DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MunicipalityDao extends BaseDao {

    public MunicipalityDao() {
        super.setModel(new Municipality());
    }

    /**
     * List Municipalitys.
     *
     * @return List of Municipalities
     */
    @Override
    public List<Municipality> all() {
        return super.all();
    }

    /**
     * Find by ID.
     *
     * @param id Identifer
     * @return Municipality
     */
    @Override
    public Municipality findById(int id) {
        return super.findById(id);
    }

    /**
     * Create Municipality.
     *
     * @param <T>
     * @param municipality Municipality
     * @return status
     */
    public <T> Integer create(Municipality municipality) {
        return super.create((BaseEntity) municipality);
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
        return super.update(id, (BaseEntity) municipality);
    }

    /**
     * Delete Municipality.
     *
     * @param id Identifier
     * @return status
     */
    @Override
    public boolean delete(int id) {
        return super.delete(id);
    }

    /**
     * Get Total Presentation By Municipality.
     *
     * @return
     */
    public Object totalPresentationsByMunicipality() {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            Query query = session.createQuery(
                    " SELECT m.name as 'municipality_name', count(p.id) as 'total_presentations' "
                    + " FROM municipalities m "
                    + " LEFT JOIN users u ON u.municipality_id = m.id "
                    + " LEFT JOIN presentations p ON p.user_id = u.id "
                    + " GROUP BY m.id "
                    + " ORDER BY m.name "
            );

            Object result = query.uniqueResult();

            trns.commit();

            return result;
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
     * Get Total Presentation By Municipality.
     *
     * @return
     */
    public List<Object> totalPresentationsDocumentsByMunicipality() {
        Transaction trns = null;
        Session session = HibernateUtil.get().getCurrentSession();

        try {
            trns = session.beginTransaction();

            Query query = session.createQuery("SELECT t FROM municipalities_total_documents_view as t");

            List<Object> result = query.getResultList();

            trns.commit();

            return result;
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
}
