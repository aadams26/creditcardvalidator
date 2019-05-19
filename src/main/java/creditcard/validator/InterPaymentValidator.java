package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * InterPayment format:
 * length = 16 - 19
 * IIN range = 637 - 639
 */
public class InterPaymentValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public InterPaymentValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() >= 16 && creditCardNumberList.size() <= 19) {
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
        int IINRange = 636;
        int IIN = parseIIN(creditCardNumberList, 3);

        if (IIN == IINRange) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
