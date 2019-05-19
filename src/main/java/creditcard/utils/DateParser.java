package creditcard.utils;

/*
 * Date parser used to standardize date format for
 * date comparison
 */
public class DateParser {

    /*
     * @param StringBuilder representation of the expiration date
     * @return expiration date StringBuilder without a backslash
     */
    public static StringBuilder parseDate(StringBuilder expirationDate) {
        if (expirationDate.toString().contains("/")) {
            expirationDate.deleteCharAt(expirationDate.indexOf("/"));
        }

        return expirationDate;
    }

    /*
     * @param a StringBuilder representation of the expiration date,
     * start & end location to be parsed
     * @return the parsed date
     */
    public static int parseDate(StringBuilder expirationDate, int startLocation, int endLocation) {
        int date = Integer.parseInt(expirationDate.substring(startLocation, endLocation));

        return date;
    }
}
