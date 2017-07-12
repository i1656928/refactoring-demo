package com.scrumtrek.simplestore;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class DemoTest {
    @Test
    public void movieShouldSaveTitleWhenNotEmpty() {
        Movie sut = new Movie("test title", PriceCodes.REGULAR);
        assertEquals("test title", sut.getTitle());
        assertEquals(PriceCodes.REGULAR, sut.getPriceCode());
    }
}
