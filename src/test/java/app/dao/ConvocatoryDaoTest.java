/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit3TestClass.java to edit this template
 */
package app.dao;

import app.entities.Convocatory;
import helpers.DateHelper;
import helpers.Log;
import java.util.Date;
import java.util.List;
import junit.framework.TestCase;

/**
 *
 * @author raulsm
 */
public class ConvocatoryDaoTest extends TestCase {

    private final String convocatoryName = "Convocatory Name Test";
    private final String convocatoryDescription = "Convocatory Description Test";

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test Create Convocatory
     *
     * @throws Exception
     */
    public void testCreateConvocatory() throws Exception {
        Integer id = null;
        boolean convocatoryCreatedSuccesfully = false;
        ConvocatoryDao convocatoryDao = new ConvocatoryDao();

        try {
            Convocatory convocatory = createConvocatory();
            id = convocatoryDao.create(convocatory);
            convocatoryCreatedSuccesfully = (id != null);
        } catch (Exception e) {
            Log.error(e);
        } finally {
            if (id != null) {
                convocatoryDao.delete(id);
            }

            assertEquals(convocatoryCreatedSuccesfully, true);
        }
    }

    /**
     * Test Delete Convocatory
     *
     * @throws Exception
     */
    public void testDeleteConvocatory() throws Exception {
        boolean convocatoryDeletedSuccesfully = false;
        ConvocatoryDao convocatoryDao = new ConvocatoryDao();

        try {
            Convocatory convocatory = createConvocatory();
            Integer id = convocatoryDao.create(convocatory);

            convocatoryDeletedSuccesfully = convocatoryDao.delete(id);
        } catch (Exception e) {
            Log.error(e);
        } finally {
            assertEquals(convocatoryDeletedSuccesfully, true);
        }
    }

    /**
     * Test Update Convocatory
     *
     * @throws Exception
     */
    public void testUpdateConvocatory() throws Exception {
        boolean convocatoryUpdatedSuccesfully = false;
        ConvocatoryDao convocatoryDao = new ConvocatoryDao();

        try {
            Convocatory convocatory = createConvocatory();
            Integer id = convocatoryDao.create(convocatory);

            convocatory.setName("Nombre convocatoria modificado");

            convocatoryUpdatedSuccesfully = convocatoryDao.update(id, convocatory);

            convocatoryDao.delete(id);
        } catch (Exception e) {
            Log.error(e);
        } finally {
            assertEquals(convocatoryUpdatedSuccesfully, true);
        }
    }

    /**
     * Test Active Convocatories
     * @throws Exception 
     */
    public void testActiveConvocatories() throws Exception {
        Integer id = null;
        ConvocatoryDao convocatoryDao = new ConvocatoryDao();
        List<Convocatory> convocatories = null;
        int counterActive = 0;
        int counterBetweenDates = 0;

        try {
            Date currentDate = new Date();

            // Create example convocatory
            Convocatory newConvocatory = createConvocatory();
            newConvocatory.setStartDate(DateHelper.subDays(currentDate, 5));
            newConvocatory.setEndDate(DateHelper.addDays(currentDate, 5));

            id = convocatoryDao.create(newConvocatory);

            // Get active convocatories
            convocatories = convocatoryDao.active();

            if (convocatories == null) {
                throw new Exception("No se han encontrado convocatorias activas");
            }

            for (Convocatory convocatory : convocatories) {
                // Check if convocatory is valid
                if (convocatory.getIsValid()) {
                    counterActive++;
                }
                // Check if convocatoy is active for current date
                if (DateHelper.isDateBetweenDates(currentDate, convocatory.getStartDate(), convocatory.getEndDate())) {
                    counterBetweenDates++;
                }
            }
        } catch (Exception e) {
            Log.error(e);
        } finally {
            if (id != null) {
                convocatoryDao.delete(id);
            }
            if (convocatories == null) {
                assertNull("No se han encontrado convocatorias activas", convocatories);
            } else {
                assertEquals("Revisar filtro 'active'", counterActive, convocatories.size());
                assertEquals("Revisar filtro 'fechas'", counterBetweenDates, convocatories.size());
            }
        }
    }

    /**
     * Create Convocatory
     *
     * @return
     */
    private Convocatory createConvocatory() {
        Date startDate = new Date();
        Date endDate = DateHelper.addDays(startDate, 30);

        return new Convocatory(convocatoryName, convocatoryDescription, startDate, endDate, true);
    }
}
