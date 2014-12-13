package tdd.vendingMachine;


import java.util.Collection;
import java.util.HashMap;

import java.util.Map;


public class Storage {
    private Map<Integer, Shelf> shelfs;

    public Storage() {
        shelfs= new HashMap<>();
    }

    public void mountNewShelfInStorage() {
        shelfs.put(0, new Shelf("default"));

    }

    public int getNumberOfShelfs() {
        return shelfs.size();
    }

    public void mountNewShelfInStorage(int shelfSlotNumber, Shelf shelfToMount) {
        shelfs.put(shelfSlotNumber, shelfToMount);

    }

    public Collection<Shelf> listAllAvailableShelfs() {
        return shelfs.values();
    }
}
