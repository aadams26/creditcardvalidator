package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * Maestro format:
 * length = 12 - 19
 * IIN range = 500000 - 509999, 560000 - 589999, 600000 - 699999
 */
public class MaestroValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public MaestroValidator(String creditCardNumber) {
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

        if (creditCardNumberList.size() >= 12 && creditCardNumberList.size() <= 19) {
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
        int[] IINRange = {500000, 509999, 560000, 589999, 600000, 699999};
        int firstSix = parseIIN(creditCardNumberList, 6);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (firstSix == i) {
                hasAllowedIINRange = true;
                break;
            }
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[2]; i <= IINRange[3]; i++) {
                if (firstSix == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[4]; i <= IINRange[5]; i++) {
                if (firstSix == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        return hasAllowedIINRange;
    }
}
