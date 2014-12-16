package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NoPriceForGivenProductException;

import java.util.HashMap;
import java.util.Map;

import static tdd.vendingMachine.TestDataConstants.*;

/**
 * Created by Witek on 2014-12-16.
 */
public class PriceList {

    private Map<ProductType, Price> priceList;

    public PriceList() {
        priceList = new HashMap<>();
        initDefaultPrices();
    }
    public PriceList(boolean init) {
        priceList = new HashMap<>();
        if(init) {
            initDefaultPrices();
        }
    }

    private void initDefaultPrices() {
        setPriceForProductType(new ProductType(COKE), new Price(COKE_PRICE));
        setPriceForProductType(new ProductType(CHOCOLATE_BAR), new Price(CHOCOLATE_BAR_PRICE));
    }

    public void setPriceForProductType(ProductType productType, Price price) {
        priceList.put(productType, price);
    }

    public Price getPriceForProductType(ProductType productType) throws NoPriceForGivenProductException{
        if(!priceList.containsKey(productType)){
            throw new NoPriceForGivenProductException();
        }
        return priceList.get(productType);
    }
}
