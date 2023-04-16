package fp.adults;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Vector;
import java.util.stream.Stream;

import fp.utils.Checkers;

public class AdultFactory {
	
	public static Adults readAdults(String fileName) {
			Adults res = null;
			
			try {
				Stream<Adult> ad = Files.lines(Paths.get(fileName)).skip(1).map(AdultFactory::parseLine);
				res = new Adults(ad);
			}catch(IOException e) {
				System.out.println("*******ERROR WITH THE FILE " + fileName + " ********");
			}
			return res;
	}
	
	
	
	public static Adult parseLine(String line){
		String[] values = line.split(";");
		String username = values[0].trim();
		String country = values[1].trim();
		LocalDate dateOfBirth = LocalDate.parse(values[2].trim(), DateTimeFormatter.ofPattern("M/d/yyyy"));
		String workclass = values[3].trim();
		String education = values[4].trim();
		String maritalStatus = values[5].trim();
		String sex = values[6].trim(); 
		Double hours = Double.valueOf(values[7].trim().replace(",", "."));
		Integer savings = Integer.valueOf(values[8].trim());
		Integer salary = Integer.valueOf(values[9].trim());
		Boolean mortgage = Boolean.valueOf(values[10].trim());
		List<Others> others = parseOthers(values[11]);
		SalaryPerHour salaryPerHour = new SalaryPerHour(salary, hours);
		
		return new Adult(username, dateOfBirth, workclass, education, maritalStatus, sex, country, mortgage, savings, salary, salaryPerHour, others);
	}

	private static List<Others> parseOthers(String oth){
		String[] res = oth.split(";");
		List<Others> otros = new Vector<>();
		for(String s:res) {
			otros.add(parseOther(s));
		}
		return otros;
	}

	private static Others parseOther(String oth) {
		String[] res = oth.split(",");
		String smartphone = res[0].trim();
		String car = res[1].trim();
		return new Others(smartphone, car);
	}
	
}
