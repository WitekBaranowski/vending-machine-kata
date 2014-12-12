package tdd.vendingMachine;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import java.util.HashMap;
import java.util.Map;


public class VendingMachineTest {




    @Test
    public void shouldReturnCokeFromShelfIfChosenOne(){
        String coke = "coke";
        Map<Integer, String> shelfs = new HashMap<>();
        shelfs.put(1, coke);

        String returnedProduct = shelfs.get(1);

        assertThat(returnedProduct).isNotNull();
        assertThat(returnedProduct).isEqualTo(coke);

    }
}
