package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 10.07.2017.
 */
public class CustomerTest {

    @Test
    public void itShouldSuccessWhenCreate(){

        String customerTestName = "Customer for TEST";
        Customer sut = new Customer(customerTestName);

        Assert.assertSame("Customer name incorrect after init", customerTestName, sut.getName());
    }

    @Test
    public void itShouldReturnEmptyStatementWhenCreate(){
        String sutName = "Dummy customer";
        Customer sut = new Customer(sutName);

        String statement = sut.Statement();

        Assert.assertTrue("Statement need contain customer", statement.contains(sutName));
        Assert.assertTrue("0 point need to be earned", statement.contains("earned 0 frequent renter points"));
        Assert.assertTrue("Amount owed need to be 0", statement.contains("Amount owed is 0"));
    }

    @Test
    public void itShouldMovieInfoWhenAddRentalForChildren(){
        String sutName = "Dummy customer";
        Customer sut = new Customer(sutName);


        String dummyMovieName = "Dummy movie";
        Movie dummyMovie = new Movie(dummyMovieName, PriceCodes.Childrens);

        // Create rentals
        int dummyRentalDays = 5;
        Rental dummyRental = new Rental(dummyMovie, dummyRentalDays);

        // Assign rentals to customers
        sut.addRental(dummyRental);

        String statement = sut.Statement();



         System.out.println(statement);

        Assert.assertTrue("Statement need contain customer", statement.contains(sutName));
        Assert.assertTrue("1 point need to be earned", statement.contains("earned 1 frequent renter points"));

        Assert.assertTrue("Amount owed need to be in statement", statement.contains("Amount owed is 3"));
        Assert.assertTrue("Movie name need to be in statement", statement.contains(dummyMovieName));
    }

    @Test
    public void itShouldMovieInfoWhenAddRentalForRegular(){
        String sutName = "Dummy customer";
        Customer sut = new Customer(sutName);


        String dummyMovieName = "Dummy movie";
        Movie dummyMovie = new Movie(dummyMovieName, PriceCodes.Regular);

        // Create rentals
        int dummyRentalDays = 5;
        Rental dummyRental = new Rental(dummyMovie, dummyRentalDays);

        // Assign rentals to customers
        sut.addRental(dummyRental);

        String statement = sut.Statement();



         System.out.println(statement);

        Assert.assertTrue("Statement need contain customer", statement.contains(sutName));
        Assert.assertTrue("1 point need to be earned", statement.contains("earned 1 frequent renter points"));

        Assert.assertTrue("Amount owed need to be 6.5 in statement", statement.contains("Amount owed is 6.5"));
        Assert.assertTrue("Movie name need to be in statement", statement.contains(dummyMovieName));
    }




}
