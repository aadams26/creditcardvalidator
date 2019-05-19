package creditcard.utils;

import java.util.Calendar;

import static creditcard.utils.DateFormatter.*;

/*
 * Date checker used to validate expiration date against
 * current year and month
 */

public class DateChecker {
    /*
     * Set the current year and month for comparison values
     */
    public static final int CURRENT_YEAR = getCurrentYear();
    public static final int CURRENT_MONTH = getCurrentMonth();

    /*
     * @param accept expiration month/year, compare against
     * current month/year
     * @return boolean representing whether or not the card
     * s expired
     */
    public static boolean compareDates(int date, int currentDate) {
        boolean isValid = false;

        if (date > currentDate) {
            isValid = true;
        }

        return isValid;
    }

    /*
     * @param String representation of the expirationDate
     * @return expirationDate as a StringBuilder
     */
    public static StringBuilder convertDate(String expirationDate) {
        StringBuilder date = new StringBuilder(expirationDate);

        return date;
    }

    /*
     * @return the current year
     */
    private static int getCurrentYear() {
        int currentYear = Integer.parseInt(yearFormat().format(Calendar.getInstance().getTime()));

        return currentYear;
    }

    /*
     * @return the current month
     */
    private static int getCurrentMonth() {
        int currentMonth = Integer.parseInt(monthFormat().format(Calendar.getInstance().getTime()));

        return currentMonth;
    }
}
