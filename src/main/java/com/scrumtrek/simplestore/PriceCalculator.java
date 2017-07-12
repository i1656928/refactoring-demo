package com.scrumtrek.simplestore;

/**
 * Created by user on 11.07.2017.
 */
public class PriceCalculator {
    public double getPrice(PriceCodes priceCode, int days){
        double retval = 0;

        if (PriceCodes.Regular == priceCode) {
            retval = 2;
            if (days >= 3) {
                retval += (days - 2) * 1.5;
            }
        } else if (PriceCodes.NewRelease == priceCode) {
            retval += days * 3;
        } else if (PriceCodes.Childrens == priceCode) {
            retval = 1.5;
            if (days >= 5)
            {
                retval += (days - 4) * 1.5;
            }
        } else {
            throw new IllegalArgumentException();
        }
      return retval;
    }
}
