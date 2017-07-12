package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

import static java.lang.Math.abs;
import static org.mockito.Mockito.mock;

/**
 * Created by user on 11.07.2017.
 */
public class PriceCalculatorTest {


        /*
        Rental stubRental = mock(Rental.class);
        Movie stubMoview = mock(Movie.class);

        when(stubRental.getMovie()).thenReturn(stubMoview);
        when(stubRental.getDaysRented()).thenReturn(1);
        when(stubMoview.getPriceCode()).thenReturn(PriceCodes.REGULAR);
         */

    public void testPrice(double expected, PriceCodes priceCode, int days)
    {
        PriceCalculator sut = new PriceCalculator();
        double res = sut.getPrice(priceCode, days);
        System.out.println(res + " " + expected);
        Assert.assertTrue("Result must be 1", abs(res - expected) < 0.001);
    }

    @Test
    public void shouldBeFixedPriceWhenFixedInput(){

        testPrice(2, PriceCodes.REGULAR, 1);
        testPrice(2, PriceCodes.REGULAR, 2);
        testPrice(3.5, PriceCodes.REGULAR, 3);
        testPrice(5, PriceCodes.REGULAR, 4);

        testPrice(1.5, PriceCodes.CHILDRENS, 1);
        testPrice(1.5, PriceCodes.CHILDRENS, 2);
        testPrice(1.5, PriceCodes.CHILDRENS, 3);
        testPrice(1.5, PriceCodes.CHILDRENS, 4);
        testPrice(3, PriceCodes.CHILDRENS, 5);

        testPrice(3, PriceCodes.NEW_RELEASE, 1);
        testPrice(6, PriceCodes.NEW_RELEASE, 2);
        testPrice(9, PriceCodes.NEW_RELEASE, 3);
        testPrice(12, PriceCodes.NEW_RELEASE, 4);


        testPrice(2 * 0.85, PriceCodes.XXX, 1);
        testPrice(2 * 0.85, PriceCodes.XXX, 2);
        testPrice(3.5 * 0.85, PriceCodes.XXX, 3);
        testPrice(5 * 0.85, PriceCodes.XXX, 4);
    }


    @Test(expected = IllegalArgumentException.class)
    public void shouldBeExceptionWhenNullPriceCode(){

        testPrice(2, null, 1);
    }
}

