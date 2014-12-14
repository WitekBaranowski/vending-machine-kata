package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;

import org.junit.Before;

import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {


    private VendingMachine vendingMachine;

    private Storage storage;

    @Before
    public void setUp() throws Exception {
        int cokePrice = 120;
        Shelf shelf = new Shelf();
        ProductType productType = new ProductType(COKE, new Price(cokePrice));
        Product product = new Product(productType);

        shelf.addProduct(product);

        storage = new Storage();
        storage.mountNewShelfInStorage(2, shelf);

        vendingMachine = new VendingMachine(storage);

    }

    @Test
    public void testDisplayingProductPriceOnVendingMachine(){


        vendingMachine.enterShelfNumber(2);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("1,2 zł");

    }
    @Test
    public void testMessageNoProductWhenChosenWrongShelf(){


        vendingMachine.enterShelfNumber(3);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("There is no shelf under number 3.");

    }




}
