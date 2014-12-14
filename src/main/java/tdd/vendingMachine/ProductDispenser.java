package tdd.vendingMachine;



public class ProductDispenser {

    private Product productInDispenser;

    public Product giveReleasedProduct() {
        return productInDispenser;
    }

    public void putPurchasedProductInDispenser(Product productFromStorage) {
        productInDispenser = productFromStorage;
    }
}
