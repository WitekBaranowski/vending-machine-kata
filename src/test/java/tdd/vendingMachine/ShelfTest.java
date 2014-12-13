package tdd.vendingMachine;


import org.junit.Test;


import static tdd.vendingMachine.TestDataConstants.*;

import static org.assertj.core.api.Assertions.assertThat;


public class ShelfTest {




    @Test
    public void testAddingItemsToShelf(){
        Shelf shelf = new Shelf(COKE);

        shelf.addProduct();
        shelf.addProduct();

        assertThat(shelf.size()).isEqualTo(2);

    }


}
