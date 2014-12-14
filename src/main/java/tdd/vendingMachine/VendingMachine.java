package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.StorageException;

import java.text.NumberFormat;
import java.util.Locale;

public class VendingMachine {

    private Storage storage;

    private int chosenShelfNumber;

    private String display;

    private Price priceForSelectedProduct;

    private long amountInserted;

    public VendingMachine(Storage storage) {
        this.storage = storage;
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        setupRemainingAmountToPay();
    }

    private void setupRemainingAmountToPay() throws StorageException {
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

    public void insertCoin(int amount) {
        amountInserted += amount;
        long remainingCost =  priceForSelectedProduct.getPriceAsPennys() - amountInserted;
        display = Price.formatPriceToString(new Price(remainingCost));
    }
}
