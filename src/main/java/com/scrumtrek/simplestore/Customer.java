package com.scrumtrek.simplestore;

import jdk.nashorn.internal.ir.annotations.Ignore;

import java.util.ArrayList;
import java.util.List;


public class Customer {
	private PriceCalculator m_PriceCalculator;
	private String m_Name;
	private FrequentRenterCalculator m_frequentRenterCalculator;
	private List<Rental> m_Rentals = new ArrayList<Rental>();

	public Customer(String name, PriceCalculator priceCalculator, FrequentRenterCalculator frequentRenterCalculator) {

		m_Name = name;
		m_PriceCalculator = priceCalculator;
		m_frequentRenterCalculator = frequentRenterCalculator;
	}

	public String getName() {
		return m_Name;
	}


	public void addRental(Rental arg){
		m_Rentals.add(arg);
	}

	public String Statement()
	{
		double totalAmount = 0;
		int frequentRenterPoints = 0;
				
		String result = "Rental record for " + m_Name + "\n";
		
		for(Rental each: m_Rentals) {
			double thisAmount = m_PriceCalculator.getPrice(each.getMovie().getPriceCode(), each.getDaysRented());
			

			frequentRenterPoints += m_frequentRenterCalculator.getPoints(each.getMovie().getPriceCode(), each.getDaysRented());

			result += "\t" + each.getMovie().getTitle() + "\t" + thisAmount + "\n";
			totalAmount += thisAmount;
		}

		// Add footer lines
		result += "Amount owed is " + totalAmount + "\n";
		result += "You earned " + frequentRenterPoints + " frequent renter points.";
		return result;
	}
}

