package creditcard.validator;

import java.util.List;

import static creditcard.utils.CreditCardParser.*;

/*
 * Visa Electron format:
 * length = 16
 * IIN range = 417500, 4026 - 4405, 4508 - 4844, 4913 - 4917
 */
public class VisaElectronValidator extends CreditCardValidator {
    private List<Integer> creditCardNumberList;

    /*
     * @param String representation of credit card number
     */
    public VisaElectronValidator(String creditCardNumber) {
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
        int[] IINRange = {417500, 4026, 4405, 4508, 4844, 4913, 4917};
        int firstFour = parseIIN(creditCardNumberList, 4);
        int firstFive = parseIIN(creditCardNumberList, 5);

        for (int number : IINRange) {
            if (number == firstFour || number == firstFive) {
                hasAllowedIINRange = true;
            }
        }

        return hasAllowedIINRange;
    }
}
