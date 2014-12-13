package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.assertThat;
import static tdd.vendingMachine.TestDataConstants.*;
import org.junit.Test;

public class StorageTest {





    @Test
    public void testAddingNewShelfToStorageOnPosition(){
        Storage storage = new Storage();
        Shelf shelfToMount = new Shelf(CHOCOLATE_BAR);

        storage.mountNewShelfInStorage(CHOCOLATE_BAR_SHELF_NUMBER, shelfToMount);

        assertThat(storage.getNumberOfShelfs()).isEqualTo(1);
        assertThat(storage.listAllAvailableShelfs()).contains(shelfToMount);
    }

    
}
