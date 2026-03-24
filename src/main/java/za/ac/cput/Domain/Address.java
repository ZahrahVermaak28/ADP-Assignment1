package za.ac.cput.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Address {
    private final String street;
    private final String city;
    private final String postalCode;

    private Address(Builder builder) {
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    public static class Builder {
        private String street;
        private String city;
        private String postalCode;

        public Builder setStreet(String street) {
            this.street = street;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setPostalCode(String postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Address build() {
            return new Address(this);
        }
    }
}