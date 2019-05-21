package creditcard.validator;

import java.util.Collections;
import java.util.List;

import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * Luhn validator used to pass the credit card number through
 * a series of algorithm checks that confirm whether or not the
 * number are valid
 */
class LuhnValidator {

    /*
     * @param String representation of the credit card number.
     * @return boolean of whether or not the number pass the
     * algorithm check.
     */
    boolean validate(String creditCardNumber) {
        return algorithmCheck(creditCardNumber);
    }

    /*
     * @param int of number that should be split into individual
     * digits
     * @return the sum of the digits
     */
    private int sumOfDigits(int number) {
        String[] tempNumberArray = Integer.toString(number).split("");
        int total = 0;
        for (String digit : tempNumberArray) {
            total += Integer.parseInt(digit);
        }

        return total;
    }

    /*
     * @param String representation of the credit card number
     * @return boolean of whether or not the number pass the
     * Luhn algorithm check
     */
    private boolean algorithmCheck(String creditCardNumber) {
        List<Integer> numberList = parseNumber(creditCardNumber);
        boolean isValid = false;
        int listSize = numberList.size();
        int[] tempArray = new int[listSize];
        int sum = 0;

        // Reverse the order
        Collections.reverse(numberList);

        // Double the value of every second digit
        for (int i = 1; i < listSize; i += 2) {
            int tempNumber = numberList.get(i) * 2;

            /*
             * If doubling results in a single digit number then add it to list
             * otherwise, add each digit together to obtain a single digit number
            */
            if (tempNumber < 10) {
                tempArray[i] = tempNumber;
            } else {
                tempArray[i] = sumOfDigits(tempNumber);
            }
        }

        // Add the remaining digits
        for (int i = 0; i < listSize; i += 2) {
            tempArray[i] = numberList.get(i);
        }

        // Take sum of all digits
        for (int number : tempArray) {
            sum += number;
        }
        // If total modulo 10 is equal to 0 then the card is valid
        if (sum % 10 == 0) {
            isValid = true;
        }

        return isValid;
    }
}
