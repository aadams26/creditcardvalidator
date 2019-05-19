package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * American Express format:
 * length = 15
 * IIN range = 34 - 37
 */
public class AmericanExpressValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public AmericanExpressValidator(String creditCardNumber) {
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
        int[] IINRange = {34, 37};
        int IIN = parseIIN(creditCardNumberList, 2);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (IIN == i) {
                hasAllowedIINRange = true;
                break;
            }
        }

        return hasAllowedIINRange;
    }
}
