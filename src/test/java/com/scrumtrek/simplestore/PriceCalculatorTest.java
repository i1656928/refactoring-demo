package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 11.07.2017.
 */
public class PriceCalculatorTest {


        /*
        Rental stubRental = mock(Rental.class);
        Movie stubMoview = mock(Movie.class);

        when(stubRental.getMovie()).thenReturn(stubMoview);
        when(stubRental.getDaysRented()).thenReturn(1);
        when(stubMoview.getPriceCode()).thenReturn(PriceCodes.Regular);
         */

    public void testPrice(double expected, PriceCodes priceCode, int days)
    {
        PriceCalculator sut = new PriceCalculator();
        double res = sut.getPrice(priceCode, days);
        // System.out.println(res);
        Assert.assertTrue("Result must be 1", (res - expected) < 0.001);
    }

    @Test
    public void shouldBeFixedPriceWhenFixedInput(){
        testPrice(2, PriceCodes.Regular, 1);
        testPrice(2, PriceCodes.Regular, 2);
        testPrice(3.5, PriceCodes.Regular, 3);
        testPrice(5, PriceCodes.Regular, 4);
        testPrice(1.5, PriceCodes.Childrens, 1);
        testPrice(1.5, PriceCodes.Childrens, 2);
        testPrice(1.5, PriceCodes.Childrens, 3);
        testPrice(3, PriceCodes.Childrens, 4);
        testPrice(3, PriceCodes.NewRelease, 1);
        testPrice(6, PriceCodes.NewRelease, 2);
        testPrice(9, PriceCodes.NewRelease, 3);
        testPrice(12, PriceCodes.NewRelease, 4);
    }

}

