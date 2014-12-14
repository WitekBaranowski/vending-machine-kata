package tdd.vendingMachine;

import tdd.vendingMachine.exceptions.NotEnoughCointToReturnChange;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CoinDispenser {
    Map<Coin, Integer> availableCoins = new HashMap<>();

    List<Coin> change = new ArrayList<>();

    public CoinDispenser() {
        availableCoins = new HashMap<>();
        availableCoins.put(Coin.FIVE_ZLOTY, 10);
        availableCoins.put(Coin.TWO_ZLOTY, 10);
        availableCoins.put(Coin.ONE_ZLOTY, 10);
        availableCoins.put(Coin.FIFTY_PENNYS, 10);
        availableCoins.put(Coin.TWENTY_PENNYS, 10);
        availableCoins.put(Coin.TEN_PENNYS, 10);

    }

    public void setCoinAmountInDispenser(Coin coin, int amount) {
        availableCoins.put(coin, amount);
    }

    public CoinDispenser(Map<Coin, Integer> availableCoins) {
        this.availableCoins = availableCoins;
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
            if(amount >= Coin.FIVE_ZLOTY.getValue() && availableCoins.get(Coin.FIVE_ZLOTY) > 0){
                amount -= Coin.FIVE_ZLOTY.getValue();
                availableCoins.put(Coin.FIVE_ZLOTY, availableCoins.get(Coin.FIVE_ZLOTY)-1);
                change.add(Coin.FIVE_ZLOTY);
            }else if(amount >= Coin.TWO_ZLOTY.getValue() && availableCoins.get(Coin.TWO_ZLOTY) > 0){
                amount -=Coin.TWO_ZLOTY.getValue();
                availableCoins.put(Coin.TWO_ZLOTY, availableCoins.get(Coin.TWO_ZLOTY)-1);
                change.add(Coin.TWO_ZLOTY);
            }else if(amount >= Coin.ONE_ZLOTY.getValue() && availableCoins.get(Coin.ONE_ZLOTY) > 0){
                amount -=Coin.ONE_ZLOTY.getValue();
                availableCoins.put(Coin.ONE_ZLOTY, availableCoins.get(Coin.ONE_ZLOTY)-1);
                change.add(Coin.ONE_ZLOTY);
            }else if(amount >= Coin.FIFTY_PENNYS.getValue() && availableCoins.get(Coin.FIFTY_PENNYS) > 0){
                amount -=Coin.FIFTY_PENNYS.getValue();
                availableCoins.put(Coin.FIFTY_PENNYS, availableCoins.get(Coin.FIFTY_PENNYS)-1);
                change.add(Coin.FIFTY_PENNYS);
            }else if(amount >= Coin.TWENTY_PENNYS.getValue() && availableCoins.get(Coin.TWENTY_PENNYS) > 0){
                amount -=Coin.TWENTY_PENNYS.getValue();
                availableCoins.put(Coin.TWENTY_PENNYS, availableCoins.get(Coin.TWENTY_PENNYS)-1);
                change.add(Coin.TWENTY_PENNYS);
            }else if(amount >= Coin.TEN_PENNYS.getValue() && availableCoins.get(Coin.TEN_PENNYS) > 0){
                amount -=Coin.TEN_PENNYS.getValue();
                availableCoins.put(Coin.TEN_PENNYS, availableCoins.get(Coin.TEN_PENNYS)-1);
                change.add(Coin.TEN_PENNYS);
            }else{
                change.clear();
                throw new NotEnoughCointToReturnChange();
            }

        }


    }

    public void putInsertedCoinsToReturn(List<Coin> insertedCoins) {
        this.change = insertedCoins;

    }
}
