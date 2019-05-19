package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * Discover format:
 * length = 16
 * IIN range = 6011, 622126 - 622925, 644 - 649, 65
 */
public class DiscoverValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public DiscoverValidator(String creditCardNumber) {
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
        int[] IINRange = {6011, 622126, 622925, 644, 649, 65};
        int firstTwo = parseIIN(creditCardNumberList, 2);
        int firstThree = parseIIN(creditCardNumberList, 3);
        int firstFour = parseIIN(creditCardNumberList, 4);
        int firstSix = parseIIN(creditCardNumberList, 6);

        if (firstFour == IINRange[0]) {
            hasAllowedIINRange = true;
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[1]; i <= IINRange[2]; i++) {
                if (firstSix == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        if (!hasAllowedIINRange) {
            for (int i = IINRange[3]; i <= IINRange[4]; i++) {
                if (firstThree == i) {
                    hasAllowedIINRange = true;
                    break;
                }
            }
        }

        if (!hasAllowedIINRange && firstTwo == IINRange[5]) {
            hasAllowedIINRange = true;
        }

        return hasAllowedIINRange;
    }
}
