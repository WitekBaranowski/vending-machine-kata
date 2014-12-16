package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.*;
import static tdd.vendingMachine.TestDataConstants.*;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

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
    @Test
    public void testFindingProductPriceFromList(){
        Map<ProductType, Price> priceList = new HashMap<>();
        priceList.put(new ProductType(COKE), new Price(COKE_PRICE));
        priceList.put(new ProductType(CHOCOLATE_BAR), new Price(CHOCOLATE_BAR_PRICE));

        assertThat(priceList.get(new ProductType(COKE))).isEqualTo(new Price(COKE_PRICE));

    }

}
