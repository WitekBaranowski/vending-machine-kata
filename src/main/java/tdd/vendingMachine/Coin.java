package tdd.vendingMachine;

/**
 * Created by Witek on 2014-12-14.
 */
public enum Coin {
    FIVE_ZLOTY(500),
    TWO_ZLOTY(200),
    ONE_ZLOTY(100),
    FIFTY_PENNYS(50),
    TWENTY_PENNYS(20),
    TEN_PENNYS(10);

    private long value;

    Coin(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }
}
