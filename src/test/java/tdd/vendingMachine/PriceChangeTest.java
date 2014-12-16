package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

/**
 * Created by Witek on 2014-12-16.
 */
public class PriceChangeTest {

    @Test
    public void testChangeProductPrice(){
        Product product = new Product(new ProductType("Test", new Price(100)));

        ProductType type = product.getProductType();
        type.changeProductTypePrice(new Price(120));


        assertThat(type.getProductPrice()).isEqualTo(new Price(120));
    }

}
