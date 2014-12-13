package tdd.vendingMachine;


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


}
