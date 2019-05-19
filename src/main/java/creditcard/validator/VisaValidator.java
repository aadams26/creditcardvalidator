package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * Visa format:
 * length = 13 - 19
 * IIN range = 4
 */
public class VisaValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public VisaValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() >= 13 && creditCardNumberList.size() <= 19) {
            hasAllowedLength = true;
        }

        return  hasAllowedLength;
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
        int IINRange = 4;
        int IIN = parseIIN(creditCardNumberList, 1);

        if (IIN == IINRange) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
