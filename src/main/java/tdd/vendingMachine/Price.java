package tdd.vendingMachine;


public class Price {

    private long value;

    public Price(int pennys) {
        this.value = pennys;
    }





    @Override
    public String toString() {
        if(value%100!=0) {
            return value / 100 + "," + value % 100;
        }else {
            return ""+value / 100;
        }
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
