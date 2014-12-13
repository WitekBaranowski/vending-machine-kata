package tdd.vendingMachine;


public class Price {

    private long value;

    public Price(int pennys) {
        this.value = pennys;
    }





    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Price price = (Price) o;

        if (value != price.value) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return (int) (value ^ (value >>> 32));
    }
}
