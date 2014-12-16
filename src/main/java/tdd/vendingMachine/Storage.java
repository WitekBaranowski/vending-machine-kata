package tdd.vendingMachine;


import tdd.vendingMachine.exceptions.StorageException;

import java.util.Collection;
import java.util.HashMap;

import java.util.Map;


public class Storage {
    private Map<Integer, Shelf> shelfs;

    public Storage() {
        shelfs= new HashMap<>();
    }


    public int getNumberOfShelfs() {
        return shelfs.size();
    }

    public void mountNewShelfInStorage(int shelfSlotNumber, Shelf shelfToMount) {
        if(shelfs.containsKey(shelfSlotNumber)){
            throw new StorageException(String.format("There is already mounted shelf at position: %d", shelfSlotNumber));
        }
        shelfs.put(shelfSlotNumber, shelfToMount);

    }

    public Collection<Shelf> listAllAvailableShelfs() {
        return shelfs.values();
    }



    public Product takeProductFromShelf(int shelfNumber) {
        if (!shelfs.containsKey(shelfNumber)) {
            throw new StorageException(String.format("There is no shelf under number %d.",shelfNumber));
        }
        Shelf shelf = shelfs.get(shelfNumber);
        return  shelf.takeProduct();
    }

    public ProductType getSelectedProductType(int shelfNumber) {
        if (!shelfs.containsKey(shelfNumber)) {
            throw new StorageException(String.format("There is no shelf under number %d.",shelfNumber));
        }
        Shelf shelf = shelfs.get(shelfNumber);
        if(shelf.size() == 0){
            throw new StorageException("There are no products on shelf.");
        }
        return  shelf.getProductType();
    }
}
