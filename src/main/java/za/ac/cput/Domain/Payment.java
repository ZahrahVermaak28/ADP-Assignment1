package za.ac.cput.Domain;

public class Payment {
    private final String paymentId;
    private final double amount;
    private final String paymentMethod;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
        this.paymentMethod = builder.paymentMethod;
    }

    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public static class Builder {
        private String paymentId;
        private double amount;
        private String paymentMethod;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public void setPaymentMethod(String paymentMethod) {
            this.paymentMethod = paymentMethod;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
