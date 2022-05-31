/**
 * Information Controller Class.
 *
 * @author raulsm
 * @version 1.0.0
 */
package app.controllers;

import app.entities.Convocatory;
import app.entities.MunicipalityTotalDocument;
import java.util.List;

/**
 * Information Controller Class.
 *
 * @author raulsm
 * @version 1.0.0
 */
public class InformationController extends BaseController {

    /**
     * Get Open Convocatories.
     *
     * @return Open Convocatories.
     */
    public static List<Convocatory> convocatoriesOpen() {
        return ConvocatoryController.active();
    }

    /**
     * Get Closed Convocatories.
     *
     * @return Closed Convocatories.
     */
    public static List<Convocatory> convocatoriesClosed() {
        return ConvocatoryController.noActive();
    }

    /**
     * *
     * Get Municipalities Presentations Total Documents.
     *
     * @return Total Presentations by Municipalities Total Documents.
     */
    public static List<MunicipalityTotalDocument> municipalitiesPresentationsTotalDocuments() {
        return MunicipalityController.municipalitiesPresentationsTotalDocuments();
    }
}
