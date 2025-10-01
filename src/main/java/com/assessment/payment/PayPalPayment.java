package com.assessment.payment;

/**
 * PayPal payment implementation
 */
public class PayPalPayment implements PaymentMethod {
    // TODO: Add private field for email (String)
    private String email;

    // TODO: Create constructor that initializes email
    public PayPalPayment(String email) {
        // TODO: IMPLEMENT: Initialize field and perform basic email format check (e.g., contains '@').
        if (email != null && !email.isEmpty() && email.contains("@")) {
            this.email = email;
        }
    }

    @Override
    public boolean processPayment(double amount) {
        // TODO: IMPLEMENT: Return true if amount > 0 and email is valid.

        return amount > 0 && !this.email.isEmpty();
    }

    @Override
    public String getPaymentDetails() {
        // TODO: IMPLEMENT: Return a string with the PayPal email
        return "PayPal Details" + this.email;
    }
}