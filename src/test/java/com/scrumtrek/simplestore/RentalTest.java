package com.scrumtrek.simplestore;

import org.junit.Test;

/**
 * Created by user on 10.07.2017.
 */

public class RentalTest {

    @Test
    public void itShouldSuccessInstanceWhenConstructorCalled(){
        Rental sut = new Rental(new Movie("Test moview", PriceCodes.NewRelease), 1);



    }
}
