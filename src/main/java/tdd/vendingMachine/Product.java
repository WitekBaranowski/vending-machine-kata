package tdd.vendingMachine;


public class Product {

    public ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productType != null ? !productType.equals(product.productType) : product.productType != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return productType != null ? productType.hashCode() : 0;
    }
}
