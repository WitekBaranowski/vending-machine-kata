package tdd.vendingMachine;


import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private String productType;
    private List<Product> productList;

    public Shelf(String productType) {
        this.productList = new ArrayList<>();
        this.productType = productType;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
    public int size(){
        return productList.size();
    }

    public void addProduct(Product product) {
        if(doesProductTypeMatchShelf(product)){
            productList.add(product);
        }else{
            throw new InvalidProductTypeException();
        }


    }
    private boolean doesProductTypeMatchShelf(Product product){
        return productType.equals(product.getProductType());
    }



}
