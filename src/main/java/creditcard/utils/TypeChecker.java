package creditcard.utils;

import creditcard.CreditCardType;
import creditcard.validator.*;

/*
 * Type checker checking against the most common
 * credit card types: VISA, AMERICAN EXPXRESS,
 * DISCOVER & MASTERCARD.
 */
public class TypeChecker {
    /*
     * @param a String representation of the credit card number
     * @return CreditCardType enumerable
     */
    public static CreditCardType checkType(String creditCardNumber) {
        CreditCardType type = null;

        // Instantiate credit card validators and set type on match
        while (type == null) {
            boolean isThisType;

            VisaValidator visaValidator = new VisaValidator(creditCardNumber);
            isThisType = visaValidator.validate();

            if (isThisType) {
                type = CreditCardType.VISA;
                break;
            }

            AmericanExpressValidator americanExpressValidator = new AmericanExpressValidator(creditCardNumber);
            isThisType = americanExpressValidator.validate();

            if (isThisType) {
                type = CreditCardType.AMERICAN_EXPRESS;
                break;
            }

            MasterCardValidator masterCardValidator = new MasterCardValidator(creditCardNumber);
            isThisType = masterCardValidator.validate();

            if (isThisType) {
                type = CreditCardType.MASTERCARD;
                break;
            }

            DiscoverValidator discoverValidator = new DiscoverValidator(creditCardNumber);
            isThisType = discoverValidator.validate();

            if (isThisType) {
                type = CreditCardType.DISCOVER;
                break;
            }

            // If credit card type does not match, mark as "other"
            if (type == null) {
                type = CreditCardType.OTHER;
                break;
            }

        }

        return type;
    }
}
