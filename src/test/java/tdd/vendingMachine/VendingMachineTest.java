package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


public class VendingMachineTest {

    static String CHOCOLATE_BAR = "chocolate bar";
    static String COKE = "coke";



    @Test
    public void shouldReturnCokeFromShelfIfChosenFirstShelf(){

        Map<Integer, String> shelfs = prepareShelfs();

        String returnedProduct = shelfs.get(1);

        assertThat(returnedProduct).isNotNull();
        assertThat(returnedProduct).isEqualTo(COKE);

    }
    @Test
    public void shouldReturnChocolateBarFromShelfIfChosenSecondShelf(){
        Map<Integer, String> shelfs = prepareShelfs();

        String returnedProduct = shelfs.get(2);

        assertThat(returnedProduct).isNotNull();
        assertThat(returnedProduct).isEqualTo(CHOCOLATE_BAR);
    }




    private Map<Integer, String> prepareShelfs() {
        Map<Integer, String> shelfs = new HashMap<>();
        shelfs.put(1, CHOCOLATE_BAR);
        shelfs.put(2, COKE);
        return shelfs;
    }


}
