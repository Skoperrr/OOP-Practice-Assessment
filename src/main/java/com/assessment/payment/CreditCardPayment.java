package com.assessment.payment;

/**
 * Credit card payment implementation
 */
public class CreditCardPayment implements PaymentMethod {
    // TODO: Add private field for cardNumber (String)
    private String cardNumber;

    // TODO: Create constructor that initializes cardNumber
    public CreditCardPayment(String cardNumber) {
        // TODO: IMPLEMENT: Initialize field and perform basic validation (e.g., not null/empty).
        if (!(cardNumber == null || cardNumber.isEmpty())) {
            this.cardNumber = cardNumber;
        }
    }

    @Override
    public boolean processPayment(double amount) {
        // TODO: IMPLEMENT: Return true if amount > 0 and cardNumber is valid.

        return amount > 0 && !this.cardNumber.isEmpty();
    }

    @Override
    public String getPaymentDetails() {
        // TODO: IMPLEMENT: Return a string with masked card number (show only last 4 digits)
        return "Credit Card Details" + this.cardNumber.substring(cardNumber.length() - 4);
    }
}