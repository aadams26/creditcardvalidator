package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * RuPay format:
 * length = 16
 * IIN range = 60, 6521 - 6522
 */
public class RuPayValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public RuPayValidator(String creditCardNumber) {
        creditCardNumberList = parseNumber(creditCardNumber);
    }

    /*
     * Check the length of the card against the format
     * requirement.
     *
     * @return boolean of whether or not credit card
     * number meet requirement.
     */
    @Override
    boolean checkLength() {
        boolean hasAllowedLength = false;

        if (creditCardNumberList.size() == 16) {
            hasAllowedLength = true;
        }

        return hasAllowedLength;
    }

    /*
     * Check that IIN meets IIN range requirement
     *
     * @return boolean of whether or not IIN matches
     * requirement
     */
    @Override
    boolean checkIINRanges() {
        boolean hasAllowedIINRange = false;
        int[] IINRange = {60, 6521, 6522};
        int firstTwo = parseIIN(creditCardNumberList, 2);
        int firstFour = parseIIN(creditCardNumberList, 4);

        if (firstTwo == IINRange[0]) {
            hasAllowedIINRange = true;
        }

        if (!hasAllowedIINRange) {
            if (firstFour == IINRange[1] || firstFour == IINRange[2]) {
                hasAllowedIINRange = true;
            }
        }
        return hasAllowedIINRange;
    }
}
