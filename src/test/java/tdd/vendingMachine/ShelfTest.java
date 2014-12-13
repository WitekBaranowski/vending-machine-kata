package tdd.vendingMachine;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


public class ShelfTest {
    static String CHOCOLATE_BAR = "chocolate bar";
    static String COKE = "coke";


    static int COKE_SHELF_NUMBER = 1;
    static int CHOCOLATE_BAR_SHELF_NUMBER = 2;


    private Map<Integer, Shelf> shelfs;

    @Before
    public void setUp() throws Exception {
        shelfs = new HashMap<>();

    }

    @Test
    public void testReturnCokeFromShelfIfChosenFirstShelf(){
        prepareShelfs(shelfs);

        Shelf returnedShelf = shelfs.get(COKE_SHELF_NUMBER);

        assertThat(returnedShelf).isNotNull();
        assertThat(returnedShelf.getProductType()).isEqualTo(COKE);

    }

    @Test
    public void testAddingItemsToShelf(){
        prepareShelfs(shelfs);

        shelfs.get(CHOCOLATE_BAR_SHELF_NUMBER).addProduct(CHOCOLATE_BAR);

        assertThat(shelfs.get(CHOCOLATE_BAR_SHELF_NUMBER).size()).isEqualTo(2);

    }


    private void prepareShelfs(Map<Integer, Shelf> shelfs) {
        shelfs.put(CHOCOLATE_BAR_SHELF_NUMBER, new Shelf(CHOCOLATE_BAR));
        shelfs.put(CHOCOLATE_BAR_SHELF_NUMBER, new Shelf(COKE));

    }
}
