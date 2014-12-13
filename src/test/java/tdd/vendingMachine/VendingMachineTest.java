package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.*;
import org.junit.Test;

import static tdd.vendingMachine.TestDataConstants.*;

public class VendingMachineTest {

    @Test
    public void testDisplayingProductPriceOnVendingMachine(){
        VendingMachine vendingMachine = new VendingMachine();

        vendingMachine.enterShelfNumber(2);
        String display = vendingMachine.showDisplay();

        assertThat(display).isEqualTo("1,2 zł");

    }




}
