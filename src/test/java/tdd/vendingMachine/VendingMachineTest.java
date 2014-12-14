package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;

import org.junit.Before;

import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {


    private VendingMachine vendingMachine;

    @Before
    public void setUp() throws Exception {
        int cokePrice = 120;
        Shelf shelf = new Shelf();
        ProductType productType = new ProductType(COKE, new Price(cokePrice));
        Product product = new Product(productType);

        shelf.addProduct(product);

        Storage storage = new Storage();
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
    @Test
    public void testInserting100PennysToVendingMachine(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(100);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("0,2 zł");

    }

    @Test
    public void testInserting50PennysVendingMachine(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(20);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("0,7 zł");

    }





}
