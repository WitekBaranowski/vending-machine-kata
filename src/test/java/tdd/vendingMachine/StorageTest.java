package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;

public class StorageTest {



    @Test
    public void testAddingNewShelfToStorage(){
        Storage storage = new Storage();

        storage.mountNewShelfInStorage();

        assertThat(storage.getNumberOfShelfs()).isEqualTo(1);
    }
    
    
}
