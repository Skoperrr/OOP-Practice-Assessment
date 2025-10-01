package com.assessment.payment;

/**
 * Cash payment implementation of PaymentMethod
 */
public class CashPayment implements PaymentMethod {
    // TODO: Add private field for amountTendered (double)
    private double amountTendered;

    // TODO: Create constructor that initializes amountTendered
    public CashPayment(double amountTendered) {
        // TODO: IMPLEMENT: Initialize field and validate amountTendered is not negative.
        if (amountTendered > 0.0) {
            this.amountTendered = amountTendered;
        }
    }

    /**
     * Calculates the change due.
     * @param amount The required payment amount.
     * @return The change due (amountTendered - amount).
     */
    public double getChange(double amount) {
        // TODO: IMPLEMENT: Return the amount of change due (ensure it's not negative).
        if (amountTendered - amount < 0.0) {
            return 0.0;
        }
        return amountTendered - amount;
    }

    @Override
    public boolean processPayment(double amount) {
        // TODO: IMPLEMENT: Return true if amountTendered >= amount
        if (amount < 0) {
            return false;
        }
        if (amountTendered >= amount){
            return true;
        }
        return false;
    }

    @Override
    public String getPaymentDetails() {
        // TODO: IMPLEMENT: Return a string showing the amount tendered.
        return "Cash Tendered" + amountTendered;
    }
}