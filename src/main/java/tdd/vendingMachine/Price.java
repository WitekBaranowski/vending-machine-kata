package tdd.vendingMachine;


import java.text.NumberFormat;
import java.util.Locale;

public class Price {

    private long value;

    public Price(long pennys) {
        this.value = pennys;
    }

    @Override
    public String toString() {
        return formatPriceToString(this);

    }
    public static String formatPriceToString(Price price) {
        double valueDecimal = price.getPriceAsPennys()/100.0;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pl-PL"));
        return currencyFormat.format(valueDecimal);

    }


    public long getPriceAsPennys() {
        return value;
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
