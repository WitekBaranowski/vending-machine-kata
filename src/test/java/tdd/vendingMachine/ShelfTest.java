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
        Product product = new Product(COKE);
        Product product2 = new Product(COKE);

        shelf.addProduct(product);
        shelf.addProduct(product2);

        assertThat(shelf.size()).isEqualTo(2);

    }
    @Test
    public void testInvalidProductTypeExceptionIsThrownWhenAddingDifferentProductsToShelf(){
        Shelf shelf = new Shelf();
        Product product = new Product(COKE);
        Product product2 = new Product(CHOCOLATE_BAR);

        exception.expect(InvalidProductTypeException.class);

        shelf.addProduct(product);
        shelf.addProduct(product2);

    }




}
