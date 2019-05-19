package creditcard.validator;

/*
 * Credit card validator abstract asserting requirements
 * for card type validation and implementing the validate
 * method.
 */

public abstract class CreditCardValidator {

    /*
     * Validate if length and IIN ranges match the card
     * type format.
     *
     * @return boolean representing whether or not card
     * card matches the card type requirements.
     */
    public boolean validate() {
        boolean isValid = false;
        boolean correctLength = checkLength();
        boolean correctIIN = checkIINRanges();

        if (correctLength && correctIIN) {
            isValid = true;
        }

        return isValid;
    }

    /*
     * Require check length and IIN range method implementation
     * at the card type validator level.
     */
    abstract boolean checkLength();
    abstract boolean checkIINRanges();
}
