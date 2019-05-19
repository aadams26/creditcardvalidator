package creditcard.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/*
 * Date formatter used by the DateChecker to parse month && year
 * out of the expiration date
 */

class DateFormatter {

    /*
     * @return a year SimpleDateFormat
     */
    static DateFormat yearFormat() {
        DateFormat yearFormat = new SimpleDateFormat("yy");

        return yearFormat;
    }

    /*
     * @return a month SimpleDateFormat
     */
    static DateFormat monthFormat() {
        DateFormat monthFormat = new SimpleDateFormat("MM");

        return monthFormat;
    }
}
