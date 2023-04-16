package fp.adults.tests;

import fp.adults.AdultFactory;
import fp.adults.Adults;

public class AdultsFactoryTest {

	public static void main(String[] args) {
		
		Adults ad = AdultFactory.readAdults("data/adults.csv");
		
		testGetAdultos(ad);
		testCheckUsername(ad, "hclover0");
		testolderThan(ad, 32, 26);
		testpeopleWithIphoneIncome(ad, 3200);
		testSavingsTotal(ad);
		testAverageIncomePerCountry(ad, "Spain");
		testUsersCountryWithMoreSavingsThan(ad, 98000, "Spain");
		testUserMortgage(ad);
		testUsersMaritalStatus(ad);
		testCountriesSocialClass(ad);
		testCountriesIncomeRange(ad, 7000);
	}
		
	private static void testGetAdultos(Adults ad) {
		System.out.println("There are " + ad.getAdultos() +" registers in the database.");
	}
		
	private static void testCheckUsername(Adults ad, String username) {
	System.out.println("Does the username " + username + "exists in the database? " + ad.checkUsername(username));
	}
	
	private static void testolderThan(Adults ad, Integer age1, Integer age2) {
	System.out.println("Are all the users in the database older than " + age1 + " ? " + ad.olderThan(age1));
	System.out.println("Are all the users in the database older than " + age2+ " ? " + ad.olderThan(age2));
	}
	
	private static void testpeopleWithIphoneIncome(Adults ad,Integer income) {
	System.out.println("The number of users having an income greater than " + income + " is " + 					ad.peopleWithGreaterIncome(income));
	}
	
	private static void testSavingsTotal(Adults ad) {
	System.out.println("The sum of all the savings of the users is " + ad.savingsTotal());
	}
	
	private static void testAverageIncomePerCountry(Adults ad, String country) {
	System.out.println("The average income in " + country + " is " + ad.averageIncomePerCountry(country));
	}
	
	private static void testUsersCountryWithMoreSavingsThan(Adults ad, Integer savings, String country) {
	System.out.println("The users in " + country + " having more savings than " + savings + " are: " + 		ad.usersCountryWithMoreSavingsThan(savings, country));
	}
	
	private static void testUserMortgage(Adults ad) {
	System.out.println("The users paying are mortgage are: " + ad.userMortgage());
	}
	
	private static void testUsersMaritalStatus(Adults ad) {
	System.out.println("The marital status of the users are: " + ad.usersMaritalStatus());
	}
	
	private static void testCountriesSocialClass(Adults ad) {
		System.out.println("The number of users belonging to each social class in each ounntry is: " + ad.countriesSocialClass());
	}
	
	private static void testCountriesIncomeRange(Adults ad, Integer income) {
		System.out.println("The number users in each country having an income greater than " + (income-250)+ " and lower than " + 	   			(income+250) +" are " + ad.countriesIncomeRange(income));
	}
	
	
}

