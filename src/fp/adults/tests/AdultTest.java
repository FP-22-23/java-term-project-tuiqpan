package fp.adults.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.adults.Adult;
import fp.adults.AdultFactory;
import fp.adults.Adults;
import fp.adults.Others;
import fp.adults.SalaryPerHour;

public class AdultTest {

	public static void main(String[] args) {
		
		
		List<Others> list = new ArrayList<Others> ();
		list.add(new Others("iPhone", "BMW"));
		
		SalaryPerHour salaryPerHour1 = new SalaryPerHour(300, 15.0);
		SalaryPerHour salaryPerHour2 = new SalaryPerHour(200, 10.0);
		
		//We check our first constructor
		Adult a1 = new Adult("klkmanin", LocalDate.of(1977,12,12),"Self Employee",
				"Bachelors", "Married", "Male","UK", true, 10000 , salaryPerHour1.getSalary(), salaryPerHour1, list);
		System.out.println(a1);
		
		//We check our second constructor
		
		Adult a2 = new Adult("etesech",LocalDate.of(1990,12,4),9000 , salaryPerHour2.getSalary(), salaryPerHour2);
		System.out.println(a2);
		
		//We test some getters and setters
		
		System.out.println("The salary per hour of the user " + a1.getUsername() + " is " + salaryPerHour1.getIncomePerHour()+ "€");
		
		a2.setMortgage(true);
		System.out.println("Is the user " + a2.getUsername() + " paying a mortgage?  " + a2.getMortgage());
		
		a1.setDateOfBirth(LocalDate.of(1976, 1, 11));
		System.out.println(a1.getUsername() + " was born on " + a1.getDateOfBirth());
		
		//We check the natural order and the equality **REMARK THAT TWO PEOPLE ARE EQUAL WHEN THEY 
		
		Adult a3 = a1;
		Adult a4 = new Adult("johnnysins224", LocalDate.of(1977,12,12),"Self Employee",
				"Bachelors", "Married", "Male","UK", true, 10090 , salaryPerHour1.getSalary(), salaryPerHour1, list);
		
		System.out.println("Are a1 and a2 equals?" + a1.equals(a2));
		System.out.println("Are a1 and a3 equals?" + a1.equals(a3));
		System.out.println("Are a1 and a4 equals?" + a1.equals(a4));
		
		System.out.println(a1.compareTo(a2));
		System.out.println(a1.compareTo(a4));
		
		

	}

}
