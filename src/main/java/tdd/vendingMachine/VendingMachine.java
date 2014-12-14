package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.StorageException;


public class VendingMachine {

    private Storage storage;

    private ProductDispenser productDispenser;

    private CoinDispenser coinDispenser;

    private int chosenShelfNumber;

    private String display;

    private Price priceForSelectedProduct;

    private long amountInserted;

    public VendingMachine(Storage storage, ProductDispenser productDispenser, CoinDispenser coinDispenser) {
        this.storage = storage;
        this.productDispenser = productDispenser;
        this.coinDispenser = coinDispenser;
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        setupTradeTransaction();

    }

    private void setupTradeTransaction() throws StorageException {
        try {
            priceForSelectedProduct = storage.getPriceForShelfNumber(chosenShelfNumber);
            display = priceForSelectedProduct.toString();
        }catch (StorageException e){
            display = e.getMessage();
        }
    }

    public String showDisplay() {
        return display;
    }

    public void insertCoin(Coin coin) {
        amountInserted += coin.getValue();

        long remainingCost =  priceForSelectedProduct.getPriceAsPennys() - amountInserted;

        display = Price.formatPriceToString(new Price(remainingCost));

        if(amountInserted >= priceForSelectedProduct.getPriceAsPennys()){
            Product productFromStorage = storage.takeProductFromShelf(chosenShelfNumber);
            productDispenser.putPurchasedProductInDispenser(productFromStorage);
            coinDispenser.calculateChange(amountInserted - priceForSelectedProduct.getPriceAsPennys());

        }
    }
}
