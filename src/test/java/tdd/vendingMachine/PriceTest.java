package tdd.vendingMachine;



import static junitparams.JUnitParamsRunner.*;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.assertj.core.api.Assertions.assertThat;


@RunWith(JUnitParamsRunner.class)
public class PriceTest {


    @Test
    @Parameters(method = "providePrices")
    public void tesPriceDisplayNoDecimal(Price price, String expPriceToDisplay){

        String priceToDisplay = price.toString();

        assertThat(priceToDisplay).isEqualTo(expPriceToDisplay);


    }
    public static Object[] providePrices() {
        return $(
                $(new Price(100), "1 zł"),
                $(new Price(120), "1,2 zł"),
                $(new Price(125), "1,25 zł"),
                $(new Price(80), "0,8 zł"),
                $(new Price(0), "0 zł")
        );
    }



}
