package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {


    @Test
    public void testProductTypePrice(){
        Price productPrice = new Price(200);
        ProductType productType = new ProductType(COKE, productPrice);


        Price price = productType.getProductPrice();

        assertThat(price).isEqualTo(productPrice);

    }

}
