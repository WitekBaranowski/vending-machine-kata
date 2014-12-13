package tdd.vendingMachine;

/**
 * Created by Witek on 2014-12-13.
 */
public class ProductType {

    private Price productPrice;
    private String name;

    public ProductType(String name, Price productPrice) {
        this.productPrice = productPrice;
        this.name = name;
    }

    public Price getProductPrice() {
        return productPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductType that = (ProductType) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
