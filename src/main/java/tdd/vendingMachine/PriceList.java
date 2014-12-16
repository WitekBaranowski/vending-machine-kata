package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NoPriceForGivenProductException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Witek on 2014-12-16.
 */
public class PriceList {

    Map<ProductType, Price> priceList = new HashMap<>();

    public void setPriceForProductType(ProductType productType, Price price) {
        priceList.put(productType, price);
    }

    public Price getPriceForProductType(ProductType productType) {
        if(!priceList.containsKey(productType)){
            throw new NoPriceForGivenProductException();
        }
        return priceList.get(productType);
    }
}
