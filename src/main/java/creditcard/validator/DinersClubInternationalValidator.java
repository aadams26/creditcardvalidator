package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.parseIIN;
import static creditcard.utils.CreditCardParser.parseNumber;

/*
 * Diners Club International format:
 * length = 16 - 19
 * IIN range = 300 - 305, 3095, 38 - 39
 */
public class DinersClubInternationalValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public DinersClubInternationalValidator(String creditCardNumber) {
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
        int[] IINRange = {300, 305, 3095, 38, 39};
        int firstTwo = parseIIN(creditCardNumberList, 2);
        int firstThree = parseIIN(creditCardNumberList, 3);
        int firstFour = parseIIN(creditCardNumberList, 4);

        for (int i = IINRange[0]; i <= IINRange[1]; i++) {
            if (firstThree == i) {
                hasAllowedIINRange = true;
                break;
            }
        }

        if (!hasAllowedIINRange) {
            if (firstFour == IINRange[2]) {
                hasAllowedIINRange = true;
            }
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[3]; i <= IINRange[4]; i++) {
                if (firstTwo == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        return hasAllowedIINRange;
    }
}
