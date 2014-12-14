package tdd.vendingMachine;


import static org.assertj.core.api.Assertions.assertThat;
import static tdd.vendingMachine.TestDataConstants.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import tdd.vendingMachine.exceptions.StorageException;


public class StorageTest {

    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testAddingNewShelfToStorageOnGivenPosition(){
        Storage storage = new Storage();
        Shelf shelfToMount = new Shelf();

        storage.mountNewShelfInStorage(CHOCOLATE_BAR_SHELF_NUMBER, shelfToMount);

        assertThat(storage.getNumberOfShelfs()).isEqualTo(1);
        assertThat(storage.listAllAvailableShelfs()).contains(shelfToMount);
    }

    @Test
    public void testStorageExceptionIsThrownWhenAddingTwoShelfsOnSamePosition(){
        Storage storage = new Storage();
        Shelf chocoShelfToMount = new Shelf();
        Shelf cokeShelfToMount = new Shelf();


        exception.expect(StorageException.class);
        exception.expectMessage("There is already mounted shelf at position: "+CHOCOLATE_BAR_SHELF_NUMBER);

        storage.mountNewShelfInStorage(CHOCOLATE_BAR_SHELF_NUMBER, chocoShelfToMount);
        storage.mountNewShelfInStorage(CHOCOLATE_BAR_SHELF_NUMBER, cokeShelfToMount);
    }



    
}
