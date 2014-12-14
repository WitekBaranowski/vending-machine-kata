package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.StorageException;

public class VendingMachine {

    private Storage storage;

    private int chosenShelfNumber;

    private String display;

    public VendingMachine(Storage storage) {
        this.storage = storage;
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        loadPriceForShelfOnDisplay();
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

    }
}
