package za.ac.cput.Domain;

public class Payment {
    private final String paymentId;
    private final double amount;
    private final String method;

    private Payment(Builder builder) {
        this.paymentId = builder.paymentId;
        this.amount = builder.amount;
        this.method = builder.method;
    }

    public String getPaymentId() { return paymentId; }
    public double getAmount() { return amount; }
    public String getMethod() { return method; }

    public static class Builder {
        private String paymentId;
        private double amount;
        private String method;

        public Builder setPaymentId(String paymentId) {
            this.paymentId = paymentId;
            return this;
        }

        public Builder setAmount(double amount) {
            this.amount = amount;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Payment build() {
            return new Payment(this);
        }
    }
}
