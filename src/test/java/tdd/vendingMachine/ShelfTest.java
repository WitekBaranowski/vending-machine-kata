package tdd.vendingMachine;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


import static tdd.vendingMachine.TestDataConstants.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ShelfTest {


    @Rule
    public ExpectedException exception = ExpectedException.none();


    @Test
    public void testAddingProductToShelf(){
        Shelf shelf = new Shelf();
        ProductType productType = new ProductType(COKE, 150);
        Product product = new Product(productType);
        Product product2 = new Product(productType);

        shelf.addProduct(product);
        shelf.addProduct(product2);

        assertThat(shelf.size()).isEqualTo(2);

    }
    @Test
    public void testInvalidProductTypeExceptionIsThrownWhenAddingDifferentProductsToShelf(){
        Shelf shelf = new Shelf();
        ProductType cokeProductType = new ProductType(COKE, 100);
        ProductType chocolateBarProductType = new ProductType(CHOCOLATE_BAR, 150);
        Product product = new Product(cokeProductType);
        Product product2 = new Product(chocolateBarProductType);

        exception.expect(InvalidProductTypeException.class);

        shelf.addProduct(product);
        shelf.addProduct(product2);

    }




}
