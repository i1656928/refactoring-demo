package com.scrumtrek.simplestore;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by user on 10.07.2017.
 */
public class MovieTest {

    @Test
    public void itShouldSuccessWhenCreatedInstancs(){

        String dummyMovieName = "Dummy moview";
        Movie sut = new Movie(dummyMovieName, PriceCodes.NewRelease);

        Assert.assertNotNull(sut);

        Assert.assertEquals("Incorrect price code after init", PriceCodes.NewRelease, sut.getPriceCode());

        Assert.assertSame("Incorrect movie name after init", dummyMovieName, sut.getTitle());
    }
}
