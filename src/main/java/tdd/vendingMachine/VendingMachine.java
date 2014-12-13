package tdd.vendingMachine;

public class VendingMachine {

    private Storage storage;

    private int chosenShelfNumber;

    private String display;

    public VendingMachine(Storage storage) {
        this.storage = storage;
    }

    public void enterShelfNumber(int shelfNumberEntered) {
        chosenShelfNumber = shelfNumberEntered;
        display = storage.getPriceForShelfNumber(chosenShelfNumber);
    }

    public String showDisplay() {
        return display;
    }
}
