package com.assessment.order;

import com.assessment.customer.Customer;
import com.assessment.payment.CashPayment;
import com.assessment.payment.PaymentMethod;
import com.assessment.products.Product;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Order class that ties everything together
 */
public class Order {
    // TODO: Add private fields for orderId (String), customer (Customer),
    // products (List<Product>), and paymentMethod (PaymentMethod)
    private String orderId;
    private Customer customer;
    private List<Product> products;
    private PaymentMethod paymentMethod;

    /**
     * Constructs an Order object, generating a unique ID and copying products from the customer's cart.
     * This is the ONLY constructor, enforcing internal ID generation.
     */
    public Order(Customer customer, PaymentMethod paymentMethod) {
        // TODO: IMPLEMENT: Initialize orderId with the UUID structure ("ORD-" + UUID.randomUUID().toString()).
        // TODO: IMPLEMENT: Initialize customer and paymentMethod fields.
        this.orderId = "ORD-" + UUID.randomUUID();
        this.customer = customer;
        this.paymentMethod = paymentMethod;
        // Products are copied from the Customer's Cart.
        // TODO: IMPLEMENT: Copy products from customer.getCart().getItems() list into the internal 'products' list.
        this.products = customer.getCart();
    }

    // TODO: Create getter for orderId
    public String getOrderId() {
        
        // return the generated ID.
        return "GENERATED_ID " + this.orderId;
    }

    public double calculateTotal() {
        // TODO: IMPLEMENT: Sum up all discounted product prices from the order list.
        return customer.getCartTotal();
    }

    public boolean processOrder() {
        // TODO: IMPLEMENT STEPS:
        // 1. Check if products list is not empty.
        // 2. Calculate total.
        // 3. Process payment using paymentMethod.processPayment(total).
        // 4. If payment is successful:
        //    a. Reduce stock quantity for each product by 1 (using Product's setter).
        //    b. Clear the customer's cart (using customer.clearCart()).
        //    c. CHALLENGE: Use 'instanceof' and Pattern Matching for 'CashPayment' to calculate and print change.
        // 5. Return success status.
        if (!products.isEmpty()) {
            if (paymentMethod.processPayment(calculateTotal())){
                products.forEach(product -> {
                    product.setStockQuantity(product.getStockQuantity() - 1);
                });
                customer.clearCart();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        // TODO: IMPLEMENT: Return a formatted summary of the order.
        return "Order Summary";
    }
}
