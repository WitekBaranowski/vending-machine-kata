package tdd.vendingMachine;


import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private String productType;
    private List<Product> productList;

    public Shelf() {
        this.productList = new ArrayList<>();

    }

    public int size(){
        return productList.size();
    }

    public void addProduct(Product product) {
        setProductTypeIfNoProductInShelf(product);

        if(doesProductTypeMatchShelf(product)){
            productList.add(product);
        }else{
            throw new InvalidProductTypeException();
        }

    }

    private void setProductTypeIfNoProductInShelf(Product product) {
        if(productList.isEmpty()){
            this.productType = product.getProductType();
        }
    }

    private boolean doesProductTypeMatchShelf(Product product){
        return productType.equals(product.getProductType());
    }



}
