package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * Verve format:
 * length = 16 - 19
 * IIN range = 506099 - 506198, 650002 - 650027
 */
public class VerveValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public VerveValidator(String creditCardNumber) {
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
        int[] IINRange = {506099, 506198, 650002, 650027};
        int IIN = parseIIN(creditCardNumberList, 6);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (IIN == i) {
                hasAllowedIINRange = true;
                break;
            }
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[0]; i <= IINRange[1]; i++) {
                if (IIN == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        return hasAllowedIINRange;
    }
}
