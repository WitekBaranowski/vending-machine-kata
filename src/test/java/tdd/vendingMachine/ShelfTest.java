package tdd.vendingMachine;


import org.junit.Test;


import static tdd.vendingMachine.TestDataConstants.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ShelfTest {




    @Test
    public void testAddingItemsToShelf(){
        Shelf shelf = new Shelf(COKE);
        Product product = new Product(COKE);


        shelf.addProduct(product);
        shelf.addProduct(product);

        assertThat(shelf.size()).isEqualTo(2);

    }

    @Test
    public void testAddingProductToShelf(){
        Shelf shelf = new Shelf(COKE);
        Product product = new Product(COKE);
        Product product2 = new Product(COKE);

        shelf.addProduct(product);
        shelf.addProduct(product2);

        assertThat(shelf.size()).isEqualTo(2);

    }
    @Test
    public void testShouldThrowInvalidArgumentExceptionWhenAddingTwoDifrentProductsToShelf(){
        Shelf shelf = new Shelf(COKE);
        Product product = new Product(COKE);
        Product product2 = new Product(CHOCOLATE_BAR);

        shelf.addProduct(product);
        shelf.addProduct(product2);

        assertThat(shelf.size()).isEqualTo(2);

    }



}
