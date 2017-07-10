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




}
