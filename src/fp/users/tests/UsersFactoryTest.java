package fp.users.tests;

import fp.users.SocialClass;
import fp.users.Users;
import fp.users.UsersFactory;

public class UsersFactoryTest {

	public static void main(String[] args) {

		Users us = UsersFactory.readUsers("data/users.csv");
		
		testGetUsers(us);
		testCheckUsername(us, "hclover0");
		testOlderThan(us, 32);
		testUsersWithIncome(us, 3200);
		testSavingsTotal(us);
		testAverageIncomePerCountry(us, "Spain");
		testUsersCountryWithMoreSavingsThan(us, 3000, "Spain");
		testUserMortgage(us, "Germany");
		testUsersMaritalStatus(us, SocialClass.MIDDLE);
		testCountriesSocialClass(us);
		testCountriesIncomeRange(us, 2000);
		testCheckUsernameStream(us, "klkmloko");
		testOlderThanStream(us, 26);
		testUsersWithIncomeStream(us, 3000);
		testSavingsTotalStream(us);
		testAverageSavingsAge(us);
		testUsersCountryWithMoreSavingsThanStream(us, 3000, "Germany");
		//UNCOMMENT TO TEST testUserMortgageStream(us, "Spain");
		testGreaterSalaryCountry(us, "Germany");
		testWorkclassList(us, "Private");
		testUsersMaritalStatusStream(us, SocialClass.LOWER);
		testAverageSalariesByEducation(us);
		testMaxSalaryByGender(us);
		testYoungestUsersMortgage(us, 3);
		testFindMostSmartphone(us);
		
		
	}
	
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";
		
	private static void testGetUsers(Users us) {
		String msg = String.format("There are '%d' registers in the database.\n", us.getSize());
		System.out.println(msg + "\nThe three first elements are:");
		us.getUsers().stream()
			.limit(3).
			forEach(System.out::println);
	}
		
	private static void testCheckUsername(Users us, String username) {
		System.out.println(ANSI_YELLOW +"\ncheckUsername TEST"+ANSI_RESET);
		try {
			System.out.println("Does the username " + username + " exists in the database? " + us.checkUsername(username));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testOlderThan(Users us, Integer age1) {
		System.out.println(ANSI_YELLOW +"\nolderThan TEST" +ANSI_RESET);
		try {
			System.out.println("Are all the users in the database older than " + age1 + " ? " + us.olderThan(age1));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
		
	private static void testUsersWithIncome(Users us,Integer income) {
		System.out.println(ANSI_YELLOW +"\npeopleWithGreaterIncome TEST"+ANSI_RESET);
		try {
			System.out.println("The number of users having an income greater than " + income + " is " + 	
					us.peopleWithGreaterIncome(income));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
		
	private static void testSavingsTotal(Users us) {
		System.out.println(ANSI_YELLOW +"\nsavingsTotal TEST"+ANSI_RESET);
		try {
			System.out.println("The sum of all the savings of the users is " + us.savingsTotal());
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testAverageIncomePerCountry(Users us, String country) {	
		System.out.println(ANSI_YELLOW +"\naverageIncomePerCountry TEST"+ANSI_RESET);
		try {
			System.out.println("The average income in " + country + " is " + us.averageIncomePerCountry(country));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}

	private static void testUsersCountryWithMoreSavingsThan(Users us, Integer savings, String country) {
		System.out.println(ANSI_YELLOW +"\nusersCountryWithMoreSavingsThan TEST"+ANSI_RESET);
		try {
			System.out.println("The users in " + country + " having more savings than " + savings + " are: " + 
					us.usersCountryWithMoreSavingsThan(savings, country));
					}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testUserMortgage(Users us, String country) {
		System.out.println(ANSI_YELLOW +"\nuserMortgage TEST"+ANSI_RESET);
		try {
			System.out.println("The users paying a mortgage in "+country+" are: " + us.userMortgage(country));
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}

	private static void testUsersMaritalStatus(Users us, SocialClass socialclass) {
		System.out.println(ANSI_YELLOW +"\nusersMaritalStatus TEST"+ANSI_RESET);
		try {
			System.out.println("The marital status of the users belonging to the given socialclass are: " + us.usersMaritalStatus(socialclass));
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}


	private static void testCountriesSocialClass(Users us) {
		System.out.println(ANSI_YELLOW +"\ncountriesSocialClass TEST"+ANSI_RESET);
		try {
			System.out.println("The number of users belonging to each social class in each ounntry is: " + us.countriesSocialClass());
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
		
	private static void testCountriesIncomeRange(Users us, Integer income) {
		System.out.println(ANSI_YELLOW +"\ncountriesIncomeRange TEST"+ANSI_RESET);
		try {
			System.out.println("The number of users in each country having an income greater than "
					+ (income-250)+ " and lower than " + (income+250) +
					" are " + us.countriesIncomeRange(income));
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
		
	private static void testCheckUsernameStream(Users us, String username) {
		System.out.println(ANSI_YELLOW +"\ncheckUsernameStream TEST"+ANSI_RESET);
		try {
			System.out.println("Does the username " + username + " exists in the database? " + us.checkUsernameStream(username));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testOlderThanStream(Users us, Integer age1) {
		System.out.println(ANSI_YELLOW +"\nolderThanStream TEST" +ANSI_RESET);
		try {
			System.out.println("Are all the users in the database older than " + age1+ " ? " + us.olderThanStream(age1));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testUsersWithIncomeStream(Users us,Integer income) {
		System.out.println(ANSI_YELLOW +"\nusersWithIncomeStream TEST"+ANSI_RESET);
		try {
			System.out.println("The number of users having an income greater than " + income + " is " + 	
					us.peopleWithGreaterIncomeStream(income));
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testSavingsTotalStream(Users us) {
		System.out.println(ANSI_YELLOW +"\nsavingsTotalStream TEST"+ANSI_RESET);
		try {
			System.out.println("The sum of all the savings of the users is " + us.savingsTotalStream());
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testAverageSavingsAge(Users us) {	
		System.out.println(ANSI_YELLOW +"\naverageSavingsAge TEST"+ANSI_RESET);
		try {
			System.out.println("The average savings of each age are " + us.averageSavingsAge());
			}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testUsersCountryWithMoreSavingsThanStream(Users us, Integer savings, String country) {
		System.out.println(ANSI_YELLOW +"\nusersCountryWithMoreSavingsThanStream TEST"+ANSI_RESET);
		try {
			System.out.println("The users in " + country + " having more savings than " + savings + " are: " + 
					us.usersCountryWithMoreSavingsThanStream(savings, country));
					}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testUserMortgageStream(Users us, String country) {
		System.out.println(ANSI_YELLOW +"\nuserMortgageStream TEST"+ANSI_RESET);
		try {
			System.out.println("The users paying a mortgage in the given country are: " +us.userMortgageStream(country));
					}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testGreaterSalaryCountry(Users us, String country) {
		System.out.println(ANSI_YELLOW +"\ngreaterSalaryCountry TEST"+ANSI_RESET);
		try {
			System.out.println("The greater salary in " + country + " is: " +us.greaterSalaryCountry(country));
					}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testWorkclassList(Users us, String workclass) {
		System.out.println(ANSI_YELLOW +"\nworkclassList TEST"+ANSI_RESET);
		try {
			System.out.println("Sorted list of users by their salary belonging to the given workclass:\n" + us.workclassList(workclass));
					}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testUsersMaritalStatusStream(Users us, SocialClass socialclass) {
		System.out.println(ANSI_YELLOW +"\nusersMaritalStatusStream TEST"+ANSI_RESET);
		try {
			System.out.println("The marital status of the users belonging to the given socialclass are: " + us.usersMaritalStatusStream(socialclass));
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testAverageSalariesByEducation(Users us) {
		System.out.println(ANSI_YELLOW +"\naverageSalariesByEducation TEST"+ANSI_RESET);
		try {
			System.out.println("The average salaries of the users of each education level are: " + us.averageSalariesByEducation());
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testMaxSalaryByGender(Users us) {
		System.out.println(ANSI_YELLOW +"\nmaxSalaryByGender TEST"+ANSI_RESET);
		try {
			System.out.println("The user of each gender in each country having the greatest salary are: " + us.maxSalaryByGender());
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testYoungestUsersMortgage(Users us, Integer n) {
		System.out.println(ANSI_YELLOW +"\nyoungestUsersMortgage TEST"+ANSI_RESET);
		try {
			System.out.println("The youngest users paying or not paying a mortgage are: " + us.youngestUsersMortgage(n));
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
	
	private static void testFindMostSmartphone(Users us) {
		System.out.println(ANSI_YELLOW +"\nfindMostSmartphone TEST"+ANSI_RESET);
		try {
			System.out.println("The most used smartphone among the users is: " + us.findMostSmartphone());
		}
		catch (Exception e) {
			System.out.println(("Unexpected exception caught:\n " + e));
			}
		}
} 

