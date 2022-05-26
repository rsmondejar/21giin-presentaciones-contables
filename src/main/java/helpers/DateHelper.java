/**
 * Date Helper.
 */
package helpers;

import java.util.Calendar;
import java.util.Date;

/**
 * Date Helper.
 *
 * @author raulsm
 */
public class DateHelper {

    /**
     * Add Days
     *
     * @param date Date
     * @param days Days to add
     * @return new Date
     */
    public static Date addDays(Date date, int days) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, days); //minus number would decrement the days
        return cal.getTime();
    }

    /**
     * Sub Days
     *
     * @param date Date
     * @param days Days to remove
     * @return new Date
     */
    public static Date subDays(Date date, int days) {
        return addDays(date, days * -1);
    }
    
    /**
     * Is Date Between Dates
     * @param date Date to check
     * @param startDate Start Date
     * @param endDate End Date
     * @return
     * @throws Exception 
     */
    public static Boolean isDateBetweenDates(Date date, Date startDate, Date endDate) throws Exception {
        if (endDate.compareTo(startDate) < 0) {
            throw new Exception("End Date must to be equal or bigger than Start Date");
        }
        
        if (date.compareTo(startDate) >= 0 && date.compareTo(endDate) <= 0) {
            return true;
        }
        
        return false;
    }
}
