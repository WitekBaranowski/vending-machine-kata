package tdd.vendingMachine;


public class Product {

    public ProductType productType;

    public Product(ProductType productType) {
        this.productType = productType;
    }

    public ProductType getProductType() {
        return productType;
    }

}
