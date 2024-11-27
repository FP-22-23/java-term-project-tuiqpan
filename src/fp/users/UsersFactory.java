package fp.users;

import java.io.IOException;
import java.util.ArrayList;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Stream;


public class UsersFactory {
	
	public static Users readUsers(String fileName) {
			Users res = null;
			
			try {
				Stream<User> ad = Files.lines(Paths.get(fileName)).skip(1).map(UsersFactory::parseLine);
				res = new Users(ad);
			}catch(IOException e) {
				System.out.println("*******ERROR WITH THE FILE " + fileName + " ********");
			}
			return res;
	}
	
	
	public static User parseLine(String line){
		String[] values = line.split(";");
		String username = values[0].trim();
		String country = values[1].trim();
		LocalDate dateOfBirth = LocalDate.parse(values[2].trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String workclass = values[3].trim();
		String education = values[4].trim();
		String maritalStatus = values[5].trim();
		String sex = values[6].trim(); 
		Double hours = Double.valueOf(values[7].trim().replace(",", "."));
		Integer savings = Integer.valueOf(values[8].trim());
		Integer salary = Integer.valueOf(values[9].trim());
		Boolean mortgage = Boolean.valueOf(values[10].trim());
		List<String> others = parseOthers(values[11]);
		SalaryPerHour salaryPerHour = new SalaryPerHour(salary, hours);
		
		return new User(username, dateOfBirth, workclass, education, maritalStatus, sex, country, mortgage, savings, salary, salaryPerHour, others);
	}

	private static List<String> parseOthers(String oth){
		String[] res = oth.split(",");
		List<String> resa = new ArrayList<>();
		for(String s:res) {
			resa.add(s);
		}
		return resa;
	}


	
}
