package tdd.vendingMachine;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class PriceTest {


    @Test
    public void tesPriceDisplayNoDecimal(){
        Price price = new Price(100);

        String priceToDisplay = price.toString();

        assertThat(priceToDisplay).isEqualTo("100");


    }
    @Test
    public void tesPriceDisplayDecimal(){
        Price price = new Price(120);

        String priceToDisplay = price.toString();

        assertThat(priceToDisplay).isEqualTo("1,20");


    }


}
