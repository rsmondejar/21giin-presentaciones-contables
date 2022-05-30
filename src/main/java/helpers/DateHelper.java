/**
 * Date Helper.
 *
 * @author raulsm
 */
package helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    
    /**
     * Format Date To yyyy-MM-dd
     * @param date
     * @return 
     */
    public static String formatToYMD(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
    
    /**
     * Get Date From String With Fromat yyyy-MM-dd
     * @param dateString Date String with format yyyy-MM-dd
     * @return Date
     * @throws ParseException 
     */
    public static Date getDateFromStringWithFormatYMD(String dateString) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.parse(dateString);
    }
    
    /**
     * Get Today Date.
     * @return Today Date.
     */
    public static Date today() {
        return new Date();
    } 
}
