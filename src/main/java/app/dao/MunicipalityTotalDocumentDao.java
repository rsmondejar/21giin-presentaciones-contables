/**
 * Municipality Total Document DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.dao;

import app.entities.BaseEntity;
import app.entities.MunicipalityTotalDocument;
import java.util.List;

/**
 * Municipality Total Document DAO.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class MunicipalityTotalDocumentDao extends BaseDao {

    public MunicipalityTotalDocumentDao() {
        super.setModel((BaseEntity) new MunicipalityTotalDocument());
    }

    /**
     * List Municipalitys.
     *
     * @return List of Municipalities
     */
    @Override
    public List<MunicipalityTotalDocument> all() {
        return super.all();
    }
}
