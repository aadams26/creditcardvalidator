package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * Mastercard format:
 * length = 16
 * IIN range = 51 - 55, 222100 - 272099
 */
public class MasterCardValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public MasterCardValidator(String creditCardNumber) {
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
        int[] IINRange = {51, 55, 222100, 272099};
        int firstTwo = parseIIN(creditCardNumberList, 2);
        int firstSix = parseIIN(creditCardNumberList, 6);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (firstTwo == i) {
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

        return hasAllowedIINRange;
    }
}
