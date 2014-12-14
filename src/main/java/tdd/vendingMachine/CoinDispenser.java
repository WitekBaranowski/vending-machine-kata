package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.List;


public class CoinDispenser {


    public List<Coin> returnChange() {

        List<Coin> change = new ArrayList<>();
        change.add(Coin.FIFTY_PENNYS);
        change.add(Coin.TWENTY_PENNYS);

        return change;
    }
}
