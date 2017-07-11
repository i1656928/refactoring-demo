package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 11.07.2017.
 */
public class FrequenceRentalCalculatorTest {

    public void testFreq(int expected, PriceCodes priceCode, int days)
    {
        FrequentRenterCalculator sut = new FrequentRenterCalculator();
            int res = sut.getPoints(priceCode, days);
        System.out.println(res);
        Assert.assertEquals("Result must be " + expected, expected, res);
    }

    @Test
    public void shouldBeFixedPriceWhenFixedInput(){
        testFreq(1, PriceCodes.Regular, 1);
        testFreq(1, PriceCodes.Regular, 2);
        testFreq(1, PriceCodes.Regular, 3);
        testFreq(1, PriceCodes.Childrens, 1);
        testFreq(1, PriceCodes.Childrens, 2);
        testFreq(1, PriceCodes.Childrens, 3);
        testFreq(1, PriceCodes.NewRelease, 1);
        testFreq(2, PriceCodes.NewRelease, 2);
        testFreq(2, PriceCodes.NewRelease, 3);
    }
}
