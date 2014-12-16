package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NotEnoughCointToReturnChange;

import java.util.*;


public class CoinDispenser {
    private Map<Coin, Integer> availableCoins = new EnumMap<>(Coin.class);

    private List<Coin> change = new ArrayList<>();

    public CoinDispenser() {
        availableCoins = new EnumMap<>(Coin.class);
        availableCoins.put(Coin.FIVE_ZLOTY, 0);
        availableCoins.put(Coin.TWO_ZLOTY, 0);
        availableCoins.put(Coin.ONE_ZLOTY, 0);
        availableCoins.put(Coin.FIFTY_PENNYS, 0);
        availableCoins.put(Coin.TWENTY_PENNYS, 0);
        availableCoins.put(Coin.TEN_PENNYS, 0);

    }

    public void setCoinAmountInDispenser(Coin coin, int amount) {
        availableCoins.put(coin, amount);
    }


    public List<Coin> returnChange() {

        List<Coin> changeToReturn = new ArrayList<>();
        for (Coin coin : change) {
            changeToReturn.add(coin);
        }
        change.clear();

        return changeToReturn;
    }



    public void calculateChange(long amount) {


        while(amount > 0){
            if(canReturnCoinInChange(amount, Coin.FIVE_ZLOTY)){
                amount = processCoinToChange(amount, Coin.FIVE_ZLOTY);

            }else if(canReturnCoinInChange(amount, Coin.TWO_ZLOTY)){
                amount = processCoinToChange(amount, Coin.TWO_ZLOTY);

            }else if(canReturnCoinInChange(amount, Coin.ONE_ZLOTY)){
                amount = processCoinToChange(amount, Coin.ONE_ZLOTY);

            }else if(canReturnCoinInChange(amount, Coin.FIFTY_PENNYS)){
                amount = processCoinToChange(amount, Coin.FIFTY_PENNYS);

            }else if(canReturnCoinInChange(amount, Coin.TWENTY_PENNYS)){
                amount = processCoinToChange(amount, Coin.TWENTY_PENNYS);

            }else if(canReturnCoinInChange(amount, Coin.TEN_PENNYS)){
                amount = processCoinToChange(amount, Coin.TEN_PENNYS);
            }else{
                change.clear();
                throw new NotEnoughCointToReturnChange();
            }

        }


    }

    private long processCoinToChange(long amount, Coin coin) {
        amount -= coin.getValue();
        availableCoins.put(coin, availableCoins.get(coin)-1);
        change.add(coin);
        return amount;
    }

    private boolean canReturnCoinInChange(long amount, Coin coin) {
        return amount >= coin.getValue() && availableCoins.get(coin) > 0;
    }

    public void putInsertedCoinsToReturn(List<Coin> insertedCoins) {
        removeInsertedCoinsFromAvailable(insertedCoins);
        returnInsertedCoins(insertedCoins);

    }

    private void returnInsertedCoins(List<Coin> insertedCoins) {
        this.change = insertedCoins;
    }

    private void removeInsertedCoinsFromAvailable(List<Coin> insertedCoins) {
        for (Coin insertedCoin : insertedCoins) {
            availableCoins.put(insertedCoin, availableCoins.get(insertedCoin)-1);
        }
    }


    public void addNewCoin(Coin coin) {
        availableCoins.put(coin, availableCoins.get(coin)+1);
    }
}
