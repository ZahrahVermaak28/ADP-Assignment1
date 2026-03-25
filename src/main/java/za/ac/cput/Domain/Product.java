package za.ac.cput.Domain;

public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private boolean isAuction;

    private Product() {
    }

    public Product(Builder builder) {
        this.productId = builder.productId;
        this.name = builder.name;
        this.description = builder.description;
        this.price = builder.price;
        this.isAuction = builder.isAuction;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAuction() {
        return isAuction;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", isAuction=" + isAuction +
                '}';
    }

    public static class Builder {

        private String productId;
        private String name;
        private String description;
        private double price;
        private boolean isAuction;

        public Builder SetProductId(String productId) {
            this.productId = productId;
            return this;
        }

        public Builder SetName(String name) {
            this.name = name;
            return this;
        }

        public Builder SetDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder SetPrice(double price) {
            this.price = price;
            return this;
        }

        public Builder SetIsAuction(boolean isAuction) {
            this.isAuction = isAuction;
            return this;
        }

        public Product build() {
            return new Product(this);
        }
    }
}
