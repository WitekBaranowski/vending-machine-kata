package tdd.vendingMachine;


import tdd.vendingMachine.exceptions.InvalidProductTypeException;
import tdd.vendingMachine.exceptions.StorageException;

import java.util.ArrayList;
import java.util.List;

public class Shelf {
    private ProductType productType;
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



    public Price getShelfProductPriceObject() {
        return productType.getProductPrice();

    }

    public Product takeProduct() {
        if(productList.isEmpty()){
            throw new StorageException("There are no products on shelf.");
        }
        Product product = productList.get(0);
        productList.remove(0);
        return product;
    }
}
