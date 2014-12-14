package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.StorageException;

import java.util.ArrayList;
import java.util.List;


public class VendingMachine {

    private Storage storage;

    private ProductDispenser productDispenser;

    private CoinDispenser coinDispenser;

    private int chosenShelfNumber;

    private String display;

    private Price priceForSelectedProduct;

    private long amountInserted;
    private List<Coin> insertedCoins;

    public VendingMachine(Storage storage, ProductDispenser productDispenser, CoinDispenser coinDispenser) {
        this.storage = storage;
        this.productDispenser = productDispenser;
        this.coinDispenser = coinDispenser;
        insertedCoins = new ArrayList<>();
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        setupTradeTransaction();

    }

    private void setupTradeTransaction() throws StorageException {
        try {
            priceForSelectedProduct = storage.getPriceForShelfNumber(chosenShelfNumber);
            setDisplayMessage(priceForSelectedProduct.toString());
        }catch (StorageException e){
            setDisplayMessage(e.getMessage());
        }
    }

    public String showDisplay() {
        return display;
    }

    public void insertCoin(Coin coin) {

        insertedCoins.add(coin);

        updateAmountInserted(coin);

        setDisplayMessage(Price.formatPriceToString(new Price(getRemainingCost())));

        if(isEnoughCoinsValueInserted()){
            Product productFromStorage = storage.takeProductFromShelf(chosenShelfNumber);
            productDispenser.putPurchasedProductInDispenser(productFromStorage);
            coinDispenser.calculateChange(changeInPennys());

        }
    }

    private long getRemainingCost() {
        return priceForSelectedProduct.getPriceAsPennys() - amountInserted;
    }

    private void updateAmountInserted(Coin coin) {
        amountInserted += coin.getValue();
    }

    private void setDisplayMessage(String message) {
        display = message;
    }

    private boolean isEnoughCoinsValueInserted() {
        return amountInserted >= priceForSelectedProduct.getPriceAsPennys();
    }

    private long changeInPennys() {
        return amountInserted - priceForSelectedProduct.getPriceAsPennys();
    }

    public void cancelTransaction() {
        coinDispenser.putInsertedCoinsToReturn(insertedCoins);

    }
}
