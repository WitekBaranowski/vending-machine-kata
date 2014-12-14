package tdd.vendingMachine;



public class ProductDispenser {

    private Product productInDispenser;

    public Product giveReleasedProduct() {
        Product toReturn = productInDispenser;
        resetDispenser();
        return toReturn;
    }

    private void resetDispenser() {
        productInDispenser = null;
    }

    public void putPurchasedProductInDispenser(Product productFromStorage) {
        productInDispenser = productFromStorage;
    }
}
