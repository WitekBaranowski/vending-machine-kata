package tdd.vendingMachine;

/**
 * Created by Witek on 2014-12-13.
 */
public class ProductType {
    private String name;

    public ProductType(String name) {
        this.name = name;
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
