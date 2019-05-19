package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * Diners Club format:
 * length = 16
 * IIN range = 54 - 55
 */
public class DinersClubValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public DinersClubValidator(String creditCardNumber) {
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
        int[] IINRange = {54, 55};
        int firstTwo = parseIIN(creditCardNumberList, 2);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (firstTwo == i) {
                hasAllowedIINRange = true;
                break;
            }
        }

        return hasAllowedIINRange;
    }
}
