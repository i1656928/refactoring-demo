package com.scrumtrek.simplestore;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 10.07.2017.
 */

public class RentalTest {

    @Test
    public void itShouldReturnMovieWhenConstructorCalled(){
        Movie movieStub = mock(Movie.class);
        Rental sut = new Rental(movieStub, 1);

        Movie actualMovie = sut.getMovie();

        Assert.assertEquals(movieStub, actualMovie);
    }

    @Test
    public void itShouldReturnDaysRentedWhenConstructorCalled(){
        Movie movieStub = mock(Movie.class);
        Rental sut = new Rental(movieStub, 42);

        int actualDaysRented = sut.getDaysRented();

        Assert.assertEquals(42, actualDaysRented);
    }
}
