package tdd.vendingMachine;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Witek on 2014-12-13.
 */
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
}
