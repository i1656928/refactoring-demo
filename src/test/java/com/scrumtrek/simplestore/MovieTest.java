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
        Movie sut = new Movie(dummyMovieName, PriceCodes.NEW_RELEASE);

        Assert.assertNotNull(sut);

        Assert.assertEquals("Incorrect price code after init", PriceCodes.NEW_RELEASE, sut.getPriceCode());

        Assert.assertSame("Incorrect movie name after init", dummyMovieName, sut.getTitle());
    }

    @Test
    public void itShouldRemovesamePriceWhenSetPrice(){
        String dummyMovieName = "Dummy movie";
        Movie sut = new Movie(dummyMovieName, PriceCodes.NEW_RELEASE);
        sut.setPriceCode(PriceCodes.CHILDRENS);
        Assert.assertEquals(PriceCodes.CHILDRENS, sut.getPriceCode());
    }
}
