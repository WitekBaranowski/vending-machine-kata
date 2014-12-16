package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NoPriceForGivenProductException;
import tdd.vendingMachine.exceptions.NotEnoughCointToReturnChange;
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

    private PriceList priceList;


    private long amountInserted;
    private List<Coin> insertedCoins;

    public VendingMachine(Storage storage, ProductDispenser productDispenser, CoinDispenser coinDispenser, PriceList priceList) {
        this.storage = storage;
        this.productDispenser = productDispenser;
        this.coinDispenser = coinDispenser;
        this.priceList = priceList;
        insertedCoins = new ArrayList<>();
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        setupTradeTransaction();

    }

    private void setupTradeTransaction() throws StorageException {
        try {
            ProductType selectedProductType = storage.getSelectedProductType(chosenShelfNumber);
            loadProductPriceFromPriceList(selectedProductType);
            setDisplayMessage(priceForSelectedProduct.toString());
        }catch (StorageException | NoPriceForGivenProductException e){
            setDisplayMessage(e.getMessage());
        }
    }

    private void loadProductPriceFromPriceList(ProductType selectedProductType) throws NoPriceForGivenProductException{
        priceForSelectedProduct = priceList.getPriceForProductType(selectedProductType);
    }

    public String showDisplay() {
        return display;
    }

    public void insertCoin(Coin coin) {

        insertedCoins.add(coin);

        updateAmountInserted(coin);

        setDisplayMessage(Price.formatPriceToString(new Price(getRemainingCost())));

        if(isEnoughCoinsValueInserted()){
            processTransaction();

        }
    }

    private void processTransaction() {
        try {
            coinDispenser.calculateChange(changeInPennys());
            setDisplayMessage("Thanks for buying our product.");
            coinDispenser.addNewCoins(insertedCoins);
            Product productFromStorage = storage.takeProductFromShelf(chosenShelfNumber);
            productDispenser.putPurchasedProductInDispenser(productFromStorage);
        }catch (NotEnoughCointToReturnChange ex){
            cancelTransaction();
            setDisplayMessage("No coins for change.");
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
