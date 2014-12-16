package tdd.vendingMachine;


public final class TestDataConstants {
    static String COKE = "coke";
    static String CHOCOLATE_BAR = "chocolate bar";

    static long COKE_PRICE = 120;
    static long CHOCOLATE_BAR_PRICE = 230;


    static int COKE_SHELF_NUMBER = 1;
    static int CHOCOLATE_BAR_SHELF_NUMBER = 2;

    private TestDataConstants(){

        throw new RuntimeException();
    }
}
