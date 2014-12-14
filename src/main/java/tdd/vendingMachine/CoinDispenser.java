package tdd.vendingMachine;

import java.util.ArrayList;
import java.util.List;


public class CoinDispenser {


    List<Coin> change = new ArrayList<>();

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
            if(amount >= Coin.FIVE_ZLOTY.getValue()){
                amount -= Coin.FIVE_ZLOTY.getValue();
                change.add(Coin.FIVE_ZLOTY);
            }else if(amount >= Coin.TWO_ZLOTY.getValue()){
                amount -=Coin.TWO_ZLOTY.getValue();
                change.add(Coin.TWO_ZLOTY);
            }else if(amount >= Coin.ONE_ZLOTY.getValue()){
                amount -=Coin.ONE_ZLOTY.getValue();
                change.add(Coin.ONE_ZLOTY);
            }else if(amount >= Coin.FIFTY_PENNYS.getValue()){
                amount -=Coin.FIFTY_PENNYS.getValue();
                change.add(Coin.FIFTY_PENNYS);
            }else if(amount >= Coin.TWENTY_PENNYS.getValue()){
                amount -=Coin.TWENTY_PENNYS.getValue();
                change.add(Coin.TWENTY_PENNYS);
            }else if(amount >= Coin.TEN_PENNYS.getValue()){
                amount -=Coin.TEN_PENNYS.getValue();
                change.add(Coin.TEN_PENNYS);
            }

        }


    }

    public void putInsertedCoinsToReturn(List<Coin> insertedCoins) {
        this.change = insertedCoins;

    }
}
