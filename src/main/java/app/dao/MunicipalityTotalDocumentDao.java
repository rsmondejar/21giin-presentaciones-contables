/**
 * Municipality Total Document DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.MunicipalityTotalDocument;

/**
 * Municipality Total Document DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MunicipalityTotalDocumentDao extends BaseDao {

    public MunicipalityTotalDocumentDao() {
        super.setModel(new MunicipalityTotalDocument());
    }
}
