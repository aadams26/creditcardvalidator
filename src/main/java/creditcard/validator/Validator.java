package creditcard.validator;

import creditcard.utils.DateParser;

import static creditcard.utils.DateChecker.*;

/*
 * Validator used to consume credit card number, expiration
 * date & CVV for validation
 */
public class Validator {
    private String creditCardNumber;
    private StringBuilder expirationDate;
    private Integer expirationYear;
    private Integer expirationMonth;
    private String CVV;

    /*
     * @param String representation of credit card number
     */
    public Validator(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /*
     * @param String representation of credit card number,
     * expiration date & CVV
     */
    public Validator(String creditCardNumber, String expirationDate, String CVV) {
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = DateParser.parseDate(convertDate(expirationDate));
        this.CVV = CVV;
        setExpirationMonth();
        setExpirationYear();
    }

    /*
     * Set expiration year
     */
    private void setExpirationYear() {
        this.expirationYear = DateParser.parseDate(expirationDate, 2, 4);
    }

    /*
     * Set expiration month
     */
    private void setExpirationMonth() {
        this.expirationMonth = DateParser.parseDate(expirationDate, 0, 2);
    }

    /*
     * Validate credit card number using Luhn algorithm
     * @throws InvalidCardException if card does not pass
     * test.
     */
    public boolean validate() throws InvalidCardException {
        LuhnValidator luhnValidator = new LuhnValidator();
        boolean isValid = luhnValidator.validate(creditCardNumber);

        if (!isValid) {
            throw new InvalidCardException("This card isn't invalid");
        }

        return isValid;
    }

    /*
     * @return boolean of whether or not the CVV matches
     * the appropriate length
     */
    public boolean checkCVV() {
        boolean isValid = false;

        if (CVV.length() == 3 || CVV.length() == 4) {
            isValid = true;
        }

        return isValid;
    }

    /*
     * @return boolean of whether or not the card is expired
     */
    public boolean checkExpirationDate() {
        boolean isValid = false;

        if (compareDates(expirationYear, CURRENT_YEAR)) {
            isValid = true;
        } else if (compareDates(expirationMonth, CURRENT_MONTH)){
            isValid = true;
        }

        return isValid;
    }
}
