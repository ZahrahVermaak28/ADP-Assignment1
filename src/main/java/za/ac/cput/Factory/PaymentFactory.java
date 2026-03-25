package za.ac.cput.Factory;

import za.ac.cput.Domain.Payment;

public class PaymentFactory {
    public static Payment createPayment(String id, double amount, String method) {

        if (id == null || method == null || amount <= 0) return null;



        return new Payment.Builder()
                .setPaymentId(id)
                .setAmount(amount)
                .setPaymentMethod(method)
                .build();
    }
}
