package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;

import org.junit.Before;

import org.junit.Test;

import java.util.List;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {



    private VendingMachine vendingMachine;

    private ProductDispenser productDispenser;

    private CoinDispenser coinDispenser;

    @Before
    public void setUp() throws Exception {

        Shelf shelf = new Shelf();
        Product product = prepareCokeProduct();

        shelf.addProduct(product);

        Storage storage = new Storage();
        storage.mountNewShelfInStorage(2, shelf);
        productDispenser = new ProductDispenser();
        coinDispenser = new CoinDispenser();
        vendingMachine = new VendingMachine(storage, productDispenser, coinDispenser);

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
    public void testInsertingOneZlotyCoinToVendingMachine(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.ONE_ZLOTY);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("0,2 zł");

    }

    @Test
    public void testInserting50PennysCoinVendingMachine(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("0,7 zł");

    }
    @Test
    public void testNoProductIsReturnedWhenNotEnoughMoney(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);

        Product boughtProduct = productDispenser.giveReleasedProduct();

        assertThat(boughtProduct).isNull();

    }


    @Test
    public void testBuyingWhenPayingExactlyRequiredAmount(){
        vendingMachine.enterShelfNumber(2);
        Product product = prepareCokeProduct();

        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.TWENTY_PENNYS);
        Product boughtProduct = productDispenser.giveReleasedProduct();

        assertThat(boughtProduct).isEqualTo(product);

    }
    @Test
    public void testChangeReturnForTwoZloty(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.ONE_ZLOTY);

        List<Coin> change = coinDispenser.returnChange();
        assertThat(change).containsExactly(Coin.FIFTY_PENNYS, Coin.TWENTY_PENNYS, Coin.TEN_PENNYS);

    }
    @Test
    public void testChangeReturnForFiveZloty(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.FIVE_ZLOTY);

        List<Coin> change = coinDispenser.returnChange();
        assertThat(change).containsExactly(Coin.TWO_ZLOTY, Coin.ONE_ZLOTY, Coin.FIFTY_PENNYS, Coin.TWENTY_PENNYS, Coin.TEN_PENNYS);

    }

    @Test
    public void testCancelingTransaction(){
        vendingMachine.enterShelfNumber(2);

        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.FIFTY_PENNYS);
        vendingMachine.insertCoin(Coin.TEN_PENNYS);
        vendingMachine.cancelTransaction();
        List<Coin> change = coinDispenser.returnChange();
        Product boughtProduct = productDispenser.giveReleasedProduct();

        assertThat(boughtProduct).isNull();
        assertThat(change).containsExactly(Coin.FIFTY_PENNYS, Coin.FIFTY_PENNYS, Coin.TEN_PENNYS);

    }
    @Test
    public void testReturningCoinsWhenCantReturnChangeAndDisplayMessage(){
        vendingMachine.enterShelfNumber(2);
        coinDispenser.setCoinAmountInDispenser(Coin.FIVE_ZLOTY, 1);
        coinDispenser.setCoinAmountInDispenser(Coin.TWO_ZLOTY, 0);
        coinDispenser.setCoinAmountInDispenser(Coin.ONE_ZLOTY, 1);
        coinDispenser.setCoinAmountInDispenser(Coin.FIFTY_PENNYS, 1);
        coinDispenser.setCoinAmountInDispenser(Coin.TWENTY_PENNYS, 0);
        coinDispenser.setCoinAmountInDispenser(Coin.TEN_PENNYS, 0);


        vendingMachine.insertCoin(Coin.FIVE_ZLOTY);



        List<Coin> change = coinDispenser.returnChange();
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("No coins for change.");
        assertThat(change).containsExactly(Coin.FIVE_ZLOTY);


    }










    private Product prepareCokeProduct() {
        ProductType productType = new ProductType(COKE, new Price(COKE_PRICE));
        return new Product(productType);
    }


}
