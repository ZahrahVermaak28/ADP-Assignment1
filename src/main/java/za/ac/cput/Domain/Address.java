package za.ac.cput.Domain;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Address {
    private  String addressId;
    private  String street;
    private  String city;
    private  String postalCode;

    private Address(Builder builder) {
        this.addressId = builder.addressId;
        this.street = builder.street;
        this.city = builder.city;
        this.postalCode = builder.postalCode;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getPostalCode() { return postalCode; }

    public static class Builder {
        private  String addressId;
        private String street;
        private String city;
        private String postalCode;

        public void setAddressId(String addressId) {
            this.addressId = addressId;
        }

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