package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Witek on 2014-12-14.
 */
public class CoinDispenser {



    public List<Coin> returnChange() {

        List<Coin> change = new ArrayList<>();
        change.add(Coin.FIFTY_PENNYS);
        change.add(Coin.TWENTY_PENNYS);

        return change;
    }
}
