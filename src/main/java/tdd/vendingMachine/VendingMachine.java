package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NotEnoughCointToReturnChange;
import tdd.vendingMachine.exceptions.StorageException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static tdd.vendingMachine.TestDataConstants.*;


public class VendingMachine {

    private Storage storage;

    private ProductDispenser productDispenser;

    private CoinDispenser coinDispenser;

    private int chosenShelfNumber;

    private String display;

    private Price priceForSelectedProduct;

    Map<ProductType, Price> priceList = new HashMap<>();


    private long amountInserted;
    private List<Coin> insertedCoins;

    public VendingMachine(Storage storage, ProductDispenser productDispenser, CoinDispenser coinDispenser) {
        this.storage = storage;
        this.productDispenser = productDispenser;
        this.coinDispenser = coinDispenser;
        insertedCoins = new ArrayList<>();
        priceList.put(new ProductType(COKE), new Price(COKE_PRICE));
        priceList.put(new ProductType(CHOCOLATE_BAR), new Price(CHOCOLATE_BAR_PRICE));
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
        }catch (StorageException e){
            setDisplayMessage(e.getMessage());
        }
    }

    private void loadProductPriceFromPriceList(ProductType selectedProductType) {
        priceForSelectedProduct = priceList.get(selectedProductType);
    }

    public String showDisplay() {
        return display;
    }

    public void insertCoin(Coin coin) {

        insertedCoins.add(coin);

        updateAmountInserted(coin);

        setDisplayMessage(Price.formatPriceToString(new Price(getRemainingCost())));

        if(isEnoughCoinsValueInserted()){
            try {
                coinDispenser.calculateChange(changeInPennys());
                coinDispenser.addNewCoins(insertedCoins);
                Product productFromStorage = storage.takeProductFromShelf(chosenShelfNumber);
                productDispenser.putPurchasedProductInDispenser(productFromStorage);
            }catch (NotEnoughCointToReturnChange ex){
                cancelTransaction();
                setDisplayMessage("No coins for change.");
            }

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
