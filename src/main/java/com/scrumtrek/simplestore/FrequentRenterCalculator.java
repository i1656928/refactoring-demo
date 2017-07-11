package com.scrumtrek.simplestore;

/**
 * Created by user on 11.07.2017.
 */
public class FrequentRenterCalculator {
    public int getPoints(PriceCodes priceCode, int days){
        // Add frequent renter points
        int frequentRenterPoints = 1;

        // Add bonus for a two-day new-release rental
        if ((priceCode == PriceCodes.NewRelease) && (days > 1))
        {
            frequentRenterPoints ++;
        }

        return frequentRenterPoints;
    }
}
