package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {

    @Test
    public void testDisplayingProductPriceOnVendingMachine(){
        Storage storage = new Storage();
        Shelf shelf = new Shelf();
        ProductType productType = new ProductType(COKE, new Price(120));
        Product product = new Product(productType);
        shelf.addProduct(product);
        storage.mountNewShelfInStorage(2, shelf);
        VendingMachine vendingMachine = new VendingMachine(storage);

        vendingMachine.enterShelfNumber(2);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("1,2 zł");

    }




}
