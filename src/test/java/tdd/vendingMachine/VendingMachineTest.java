package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {


    @Test
    public void testProductTypePrice(){
        long productPrice = 200;
        ProductType productType = new ProductType(COKE, productPrice);


        long price = productType.getProductPrice();

        assertThat(price).isEqualTo(200);


    }

}
