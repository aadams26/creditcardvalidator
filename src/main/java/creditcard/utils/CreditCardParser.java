package creditcard.utils;

import java.util.ArrayList;
import java.util.List;

/*
 * Credit card parser used to parse credit card Number and IIN
 */

public class CreditCardParser {

    /*
     * @param credit card number as a String
     * @return credit card number as a List of Integers
     */
    public static List<Integer> parseNumber(String creditCardNumber) {
        List<Integer> creditCardNumberList = new ArrayList<>();

        for (char number : creditCardNumber.toCharArray()) {
            int tempNumber = Character.getNumericValue(number);
            creditCardNumberList.add(tempNumber);
        }

        return creditCardNumberList;
    }

    /*
     * @param credit card number as a List of Integers and
     * the IIN range to test
     * @return the IIN value to test
     */
    public static int parseIIN(List<Integer> creditCardNumberList, int range) {
        StringBuilder IINString = new StringBuilder(range);
        int IIN;

        for (int i = 0; i < range; i++) {
            IINString.append(creditCardNumberList.get(i));
        }
        IIN = Integer.parseInt(IINString.toString());

        return IIN;
    }
}
