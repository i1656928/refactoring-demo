package com.scrumtrek.simplestore;

import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by user on 10.07.2017.
 */
public class CustomerTest {
    @Test
    public void itShouldMovieInfoWhenAddRentalForRegular(){
        String sutName = "Dummy customer";
        Rental stubRental = mock(Rental.class);
        Movie stubMoview = mock(Movie.class);

        when(stubRental.getMovie()).thenReturn(stubMoview);
        when(stubRental.getDaysRented()).thenReturn(5);
        when(stubMoview.getPriceCode()).thenReturn(PriceCodes.Regular);
        when(stubMoview.getTitle()).thenReturn("Stub moview");

        Customer sut = new Customer(sutName, new PriceCalculator(), new FrequentRenterCalculator());


        // Create rentals

        // Assign rentals to customers
        sut.addRental(stubRental);

        String statement = sut.Statement();



        System.out.println(statement);

        Assert.assertTrue("Statement need contain customer", statement.contains(sutName));
        Assert.assertTrue("1 point need to be earned", statement.contains("earned 1 frequent renter points"));

        Assert.assertTrue("Amount owed need to be 6.5 in statement", statement.contains("Amount owed is 6.5"));
        Assert.assertTrue("Movie name need to be in statement", statement.contains("Stub movie"));
    }

    @Test
    public void itShouldMovieInfoWhenAddRentalForChildren(){
        String sutName = "Dummy customer";

        Rental stubRental = mock(Rental.class);
        Movie stubMoview = mock(Movie.class);

        when(stubRental.getMovie()).thenReturn(stubMoview);
        when(stubRental.getDaysRented()).thenReturn(5);
        when(stubMoview.getPriceCode()).thenReturn(PriceCodes.Childrens);
        when(stubMoview.getTitle()).thenReturn("Stub moview");

        Customer sut = new Customer(sutName, new PriceCalculator(), new FrequentRenterCalculator());


        // Assign rentals to customers
        sut.addRental(stubRental);

        String statement = sut.Statement();



        System.out.println(statement);

        Assert.assertTrue("Statement need contain customer", statement.contains(sutName));
        Assert.assertTrue("1 point need to be earned", statement.contains("earned 1 frequent renter points"));

        Assert.assertTrue("Amount owed need to be in statement", statement.contains("Amount owed is 3"));
        Assert.assertTrue("Movie name need to be in statement", statement.contains("Stub movie"));
    }

    @Test
    public void itShouldTwoPointEarnedWhenRentNewReleaseForLong(){
        String sutName = "Dummy customer";
        Rental stubRental = mock(Rental.class);
        Movie stubMoview = mock(Movie.class);

        when(stubRental.getMovie()).thenReturn(stubMoview);
        when(stubRental.getDaysRented()).thenReturn(50);
        when(stubMoview.getPriceCode()).thenReturn(PriceCodes.NewRelease);
        when(stubMoview.getTitle()).thenReturn("Stub moview");

        Customer sut = new Customer(sutName, new PriceCalculator(), new FrequentRenterCalculator());


        // Create rentals

        // Assign rentals to customers
        sut.addRental(stubRental);

        String statement = sut.Statement();



        System.out.println(statement);

        Assert.assertTrue("2 point need to be earned", statement.contains("earned 2 frequent renter points"));
    }



    @Test
    public void itShouldReturnSameNameWhenCreated(){
        String sutName = "Dummy";
        Customer sut = new Customer(sutName, null, null);
        Assert.assertEquals(sutName, sut.getName());
    }

}
