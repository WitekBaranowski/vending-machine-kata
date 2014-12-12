package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


public class VendingMachineTest {

    static String CHOCOLATE_BAR = "chocolate bar";
    static String COKE = "coke";

    private Map<Integer, Shelf> shelfs;

    @Before
    public void setUp() throws Exception {
        shelfs = new HashMap<>();

    }

    @Test
    public void shouldReturnCokeFromShelfIfChosenFirstShelf(){
        prepareShelfs(shelfs);

        Shelf returnedShelf = shelfs.get(1);

        assertThat(returnedShelf).isNotNull();
        assertThat(returnedShelf.getProductType()).isEqualTo(COKE);

    }
    @Test
    public void shouldReturnChocolateBarFromShelfIfChosenSecondShelf(){
        prepareShelfs(shelfs);

        Shelf returnedShelf = shelfs.get(2);

        assertThat(returnedShelf).isNotNull();
        assertThat(returnedShelf.getProductType()).isEqualTo(CHOCOLATE_BAR);
    }

    @Test
    public void testAddingItemsToShelf(){
        prepareShelfs(shelfs);

        shelfs.get(1).addProduct(CHOCOLATE_BAR);

        assertThat(shelfs.get(1).size()).isEqualTo(2);

    }





    private void prepareShelfs(Map<Integer, Shelf> shelfs) {
        shelfs.put(1, new Shelf(CHOCOLATE_BAR));
        shelfs.put(2, new Shelf(COKE));

    }


}
