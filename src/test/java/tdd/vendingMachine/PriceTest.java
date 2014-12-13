package tdd.vendingMachine;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static tdd.vendingMachine.TestDataConstants.COKE;


public class PriceTest {

    @Test
    public void testProductTypePrice(){
        Price productPrice = new Price(200);
        ProductType productType = new ProductType(COKE, productPrice);

        Price price = productType.getProductPrice();

        assertThat(price).isEqualTo(productPrice);

    }

    @Test
    public void tesPriceDisplayNoDecimal(){
        Price price = new Price(100);

        String priceToDisplay = price.toString();

        assertThat(priceToDisplay).isEqualTo("1 zł");


    }
    @Test
    public void tesPriceDisplayDecimal(){
        Price price = new Price(120);

        String priceToDisplay = price.toString();

        assertThat(priceToDisplay).isEqualTo("1,2 zł");

    }


}
