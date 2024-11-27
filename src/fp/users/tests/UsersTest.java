package fp.users.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import fp.users.SalaryPerHour;
import fp.users.User;

public class UsersTest {
	
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_RESET = "\u001B[0m";

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		list.add("iPhone");
		list.add("BMW");
		
		SalaryPerHour salaryPerHour1 = new SalaryPerHour(300, 15.0);
		SalaryPerHour salaryPerHour2 = new SalaryPerHour(200, 10.0);
		
		//We check our first constructor
		User a1 = new User("klkmanin", LocalDate.of(1977,12,12),"Self Employee",
				"Bachelors", "Married", "Male","UK", true, 10000 , salaryPerHour1.getSalary(), salaryPerHour1, list);
		
		System.out.println(ANSI_YELLOW + "USER1\n" +ANSI_RESET + a1 );
		
		//We check our second constructor
		
		User a2 = new User("etesech",LocalDate.of(1990,12,4),9000 , salaryPerHour2.getSalary(), salaryPerHour2);
		System.out.println(ANSI_YELLOW + "\nUSER2\n" +ANSI_RESET +a2);
		
		//We test some getters and setters
		
		System.out.println(ANSI_YELLOW + "\nGETTERS AND SETTERS TEST\n" +ANSI_RESET +"The salary per hour of the user " + a1.getUsername() + " is " + salaryPerHour1.getIncomePerHour());
		
		a2.setMortgage(true);
		System.out.println("Is the user " + a2.getUsername() + " paying a mortgage?  " + a2.getMortgage());
		
		a1.setDateOfBirth(LocalDate.of(1976, 1, 11));
		System.out.println(a1.getUsername() + " was born on " + a1.getDateOfBirth());
		
		//We check the natural order and the equality **REMARK THAT TWO PEOPLE ARE EQUAL WHEN THEY 
		
		User a3 = a1;
		User a4 = new User("johnnysins224", LocalDate.of(1977,12,12),"Self Employee",
				"Bachelors", "Married", "Male","UK", true, 10090 , salaryPerHour1.getSalary(), salaryPerHour1, list);
		System.out.println(ANSI_YELLOW + "\nNATURAL ORDER TEST" +ANSI_RESET);
		System.out.println("Are a1 and a2 equals?" + a1.equals(a2));
		System.out.println("Are a1 and a3 equals?" + a1.equals(a3));
		System.out.println("Are a1 and a4 equals?" + a1.equals(a4));
		
		System.out.println(ANSI_YELLOW + "\nCOMPARE TO TEST" +ANSI_RESET);
		System.out.println(a1.compareTo(a2));
		System.out.println(a1.compareTo(a4));
		
		

	}

}