package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * UATP format:
 * length = 15
 * IIN range = 1
 */
public class UATPValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public UATPValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() == 15) {
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
        int IINRange = 1;
        int IIN = parseIIN(creditCardNumberList, 6);

        if (IIN == IINRange) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
