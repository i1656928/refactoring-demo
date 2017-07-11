package com.scrumtrek.simplestore;

/**
 * Created by user on 11.07.2017.
 */
public class PriceCalculator {
    public double getPrice(PriceCodes priceCode, int days){
        double retval = 0;
        switch(priceCode) {
            case Regular:
                retval = 2;
                if (days >= 3) {
                    retval += (days - 2) * 1.5;
                }
                break;

            case NewRelease:
                retval += days * 3;
                break;

            case Childrens:
                retval = 1.5;
                if (days >= 5)
                {
                    retval += (days - 4) * 1.5;
                }
        }
      return retval;
    }


}
