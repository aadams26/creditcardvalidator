package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * Maestro UK format:
 * length = 12 - 19
 * IIN range = 6759, 676770 - 676774
 */
public class MaestroUKValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public MaestroUKValidator(String creditCardNumber) {
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
        int[] IINRange = {6759, 676770, 676774};
        int firstFour = parseIIN(creditCardNumberList, 4);
        int firstSix = parseIIN(creditCardNumberList, 6);

        if (firstFour == IINRange[0]) {
            hasAllowedIINRange = true;
        }

        if (firstSix == IINRange[1]) {
            hasAllowedIINRange = true;
        }

        if (firstSix == IINRange[2]) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
