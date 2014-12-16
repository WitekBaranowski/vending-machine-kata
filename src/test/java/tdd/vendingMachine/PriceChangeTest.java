package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.*;
import static tdd.vendingMachine.TestDataConstants.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tdd.vendingMachine.exceptions.NoPriceForGivenProductException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Witek on 2014-12-16.
 */
public class PriceChangeTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testFindingProductPriceFromList(){
        Map<ProductType, Price> priceList = new HashMap<>();
        priceList.put(new ProductType(COKE), new Price(COKE_PRICE));
        priceList.put(new ProductType(CHOCOLATE_BAR), new Price(CHOCOLATE_BAR_PRICE));

        assertThat(priceList.get(new ProductType(COKE))).isEqualTo(new Price(COKE_PRICE));

    }
    @Test
    public void testFindingProductPriceFromPriceList(){
        PriceList priceList = new PriceList();

        priceList.setPriceForProductType(new ProductType(COKE), new Price(COKE_PRICE));

        assertThat(priceList.getPriceForProductType(new ProductType(COKE))).isEqualTo(new Price(COKE_PRICE));

    }
    @Test
    public void testFindingProductPriceFromPriceListThrow_NoPriceForGivenProductExceptionWhenNoPriceSetForProduct(){
        PriceList priceList = new PriceList();

        exception.expect(NoPriceForGivenProductException.class);

        priceList.getPriceForProductType(new ProductType(COKE));

    }

}
