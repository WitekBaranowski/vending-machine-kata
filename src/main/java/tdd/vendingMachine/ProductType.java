package tdd.vendingMachine;

/**
 * Created by Witek on 2014-12-13.
 */
public class ProductType {

    private long productPrice;

    public ProductType(String productType, long productPrice) {
        this.productPrice = productPrice;
    }

    public long getProductPrice() {
        return productPrice;
    }
}
