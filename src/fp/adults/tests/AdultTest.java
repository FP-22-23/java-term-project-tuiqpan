package fp.adults.tests;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import fp.adults.Adult;
import fp.adults.Others;
import fp.adults.SalaryPerHour;

public class AdultTest {

	public static void main(String[] args) {
		
		List<Others> list = new ArrayList<Others> ();
		
		list.add(new Others("iPhone", "BMW", "Others"));
		
		SalaryPerHour salaryPerHour = new SalaryPerHour(700, 20.0);
		
		Adult s = new Adult("Germany", LocalDate.of(1970,12,1), "Self Employee" , "Bachelors", "Married", "Male", true, 
					10000 , salaryPerHour.getSalary(), salaryPerHour, list);
		
		System.out.println(s);
		

	}

}
