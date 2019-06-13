[![Build Status](https://travis-ci.org/aadams26/creditcardvalidator.svg?branch=master)](https://travis-ci.org/aadams26/creditcardvalidator.svg?branch=master)

# Credit Card Validator

A java library that utilizes the Luhn algorithm to test for validity of 
numeric credit card combinations. Additionally, the validation package 
provides utility classes to check credit card type, expiration date and 
CVV.

## Supported card types
The following are the supported credit card types:

**Common types**
* VISA, VISA Electron
* American Express
* Mastercard
* Discover

**Additional types**
* JCB
* Maestro, Maestro UK
* China Union, China T-Union
* Dankort
* Diners Club, Diners Club International
* InstaPayment
* InterPayment
* LankaPay
* MIR
* NPS Pridnestrovie
* RuPay
* Troy
* UATP
* Verve

## Type Validators
This library provides issuer-based validators for custom implementations 
and a [TypeChecker](#-TypeChecker) utility class that compares the credit card number against 
common types.
***
### Issuer-based validator usage
```java
// To utilize individual validators, instantiate the validator
VisaValidator visaValidator = new VisaValidator("4547250466466268");

// Then validate
boolean isValid = visaValidator.validate();
```

## Utility classes
***
**List of utility classes:**

### [CreditCardParser](#-CreditCardParser)

└── **parseNumber(String creditCardNumber)**

├── **parseIIN(List<Integer> creditCardNumberList, int range)**

### [DateChecker](#-DateChecker)

└── **CURRENT_YEAR**

├── **CURRENT_MONTH**

├── **compareDates(int date, int currentDate)**

├── **convertDate(String expirationDate)**

### [DateParser](#-DateParser)

└── **parseDate(StringBuilder expirationDate)**

├── **parseDate(StringBuilder expirationDate, int startLocation, int endLocation)**

### [TypeChecker](#-TypeChecker)

└── **checkType(String creditCardNumber)**
***

### # CreditCardParser
The credit card parser provides static utility methods used 
to parse credit card number and IIN to compare against the 
accepted IIN ranges set by issuers.

#### parseNumber(String creditCardNumber)
Consumes the String representation of credit card number and 
returns the parsed value as a List of Integers.

**Usage**
```java
List<Integer> creditCardNumberList = new ArrayList<>();
creditCardNumberList = CreditCardParser.parseNumber("4547250466466268");
```

#### parseIIN(List<Integer> creditCardNumberList, int range)
Consumes the List representation of parsed credit card number 
and the IIN range. Then returns the IIN value.

**Usage**
```java
List<Integer> creditCardNumberList = new ArrayList<>();
creditCardNumberList = CreditCardParser.parseNumber("4547250466466268");
```

### # DateChecker
The date checker provides static utility classes and constants to 
compare the expiration date of the credit card against the current 
year and month.

#### CURRENT_YEAR
A static constant of the current year.

#### CURRENT_MONTH
A static constant of the current month.

#### compareDates(int date, int currentDate)
A static method that consumes the expiration month/year and current 
month/year then returns a boolean of whether or not the value passes.
```java
boolean isValid = DateChecker.compareDates("11", CURRENT_MONTH);
```

#### convertDate(String expirationDate)
A static method that consumes the String representation of the credit
card number and returns a StringBuilder.
```java
StringBuilder expirationDate = DateChecker.convertDate("11/20");
```

### # DateParser
The date parser provides utility classes to parse the expiration date.

#### parseDate(StringBuilder expirationDate)
A static method that consumes a StringBuilder representation of the expiration 
date and returns a standardized StringBuilder value without the backslash.
```java
StringBuilder parsedExpirationDate = DateParser.parseDate(expirationDate);
```

#### parseDate(StringBuilder expirationDate, int startLocation, int endLocation)
A static method that consumes a StringBuilder representation of the expiration 
date, the start and end location to parse out then returns the parsed value as an int.
```java
int month = DateParser.parseDate(expirationDate, 0, 2);
```

### # TypeChecker
The type checker provides a static method that is utilized to check the credit card
number against the common credit card types from the supported credit card type list
of this library.

#### checkType(String creditCardNumber)
A static method that runs the credit card number through the common credit card
type validators and returns the type with a fallback of OTHER.
```java
CreditCardType.checkType("4547250466466268");
```
