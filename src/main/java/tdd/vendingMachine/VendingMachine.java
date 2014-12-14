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
        loadPriceForShelfOnDisplay();
        try {
            priceForSelectedProduct = storage.getPriceObjectForShelfNumber(chosenShelfNumber);
        }catch (StorageException e){
            display = e.getMessage();
        }
    }

    private void loadPriceForShelfOnDisplay() {
        try {
            display = storage.getPriceForShelfNumber(chosenShelfNumber);
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
        double valueDecimal = remainingCost/100.0;
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("pl-PL"));

        display = currencyFormat.format(valueDecimal);
    }
}
