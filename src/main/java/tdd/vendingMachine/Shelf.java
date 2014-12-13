package tdd.vendingMachine;


public class Shelf {
    private String productType;
    private int size;

    public Shelf(String productType) {
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    public int size(){
        return size;
    }

    public void addProduct() {
        size++;
    }



}
