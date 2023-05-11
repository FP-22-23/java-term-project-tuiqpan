package fp.users;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Users {
	
	
	private List<User> Users;
	
	
	//Collection of adults using stream (Type Users)
	public Users(Stream<User> u) {
		Users = u.collect(Collectors.toList());
	}
	
	//Collection of Users (Type Users)
	public Users(Collection<User> u) {
		Users = new ArrayList<User>(u);
	}
	
	//Empty collection of adults 
	public Users() {
		Users = new ArrayList<User>();
	}

	//Gets the size of the database
	public Integer getSize() {
		return Users.size();
	}
	
	//Getter
	public List<User> getUsers() {
		return Users;
	}

	//Adds a register
	public void add(User user) {
		Users.add(user);
	}
	
	//Remove a register
    public void remove(User user) {
    	Users.remove(user);
    }
    
	@Override
	public String toString() {
		return "Users [registers=" + Users + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(Users);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(Users, other.Users);
	}
	
	
	//SECOND DELIVERY
	
	//Checks if exists a certain username in the database
	public Boolean checkUsername(String username) {
		Boolean res = false;
		for(User a : Users) {
			if(a.getUsername().equals(username)) {
				res = true;
			}
		}
		return res;
	}
	
	//Checks if all users in the list are older than the given age
	public Boolean olderThan(Integer age) {
		Boolean res = true;
		for(User a : Users) {
			if(a.getAge()<=age) {
				res = false;
				break;
			}
		}
		return res;
	}
	
	//Counts how many users have an income greater than the given value
	public Integer peopleWithGreaterIncome(Integer income) {
		Integer res = 0;
		for(User a: Users) {
			if(a.getSalary()>=(income)) {
					res ++;
			}
		}
	return res;
	}
	
	//Sum the total number of savings of the users
	public Integer savingsTotal() {
		Integer res = 0;
		for(User a: Users) {
				res += a.getSavings();
				
			}
	return res;
	}
	
	//Compute the average income of the users in the database in a given country
	public Integer averageIncomePerCountry(String country) {
	    Integer res = 0;
	    Integer count = 0;
	    for(User a: Users) {
	        if(a.getCountry().equalsIgnoreCase(country)) {
	            res += a.getSalary();
	            count++;
	        }
	    }
	    return Math.round(res/count);
	}
	
	//Creates a list with the users from a certain country having more savings than a given number
	public List<String> usersCountryWithMoreSavingsThan(Integer savings, String country){
		List<String> res = new ArrayList<>();
		for(User a: Users) {
			if(a.getSavings()>savings && a.getCountry().equals(country)) {
				res.add(a.getUsername());
			}
		}
		return res;
	}
	
	//Creates a list with the users paying a mortgage from a given country
	public List<String> userMortgage(String country){
		List<String> res = new ArrayList<>();
		for(User a: Users) {
			if(a.getCountry().equals(country)) {
				if(a.getMortgage().equals(true)) {
					res.add(a.getUsername());
				}	
				
			}
			
		}
		return res;
	}
	
	//Returns a map that represents the marital status of the users from a given social class
	public Map<String, List<String>> usersMaritalStatus(SocialClass socialclass){
		Map<String, List<String>> res = new HashMap<>();

		for(User a : Users) {
			if(socialclass==a.getSocialClass())
				if(res.containsKey(a.getMaritalStatus())) {
					res.get(a.getMaritalStatus()).add(a.getUsername());
				}
				else {
					List<String> lista = new ArrayList<>();
					lista.add(a.getUsername());
					res.put(a.getMaritalStatus(), lista);
				}
		}
		return res;
		}
	
	//Returns a map that represents the number of users belonging to each social class
	//in each country
	public Map<String, Map<SocialClass, Integer>> countriesSocialClass() {
	    Map<String, Map<SocialClass, Integer>> res = new HashMap<>();
	    for (User a : Users) {
	        if (res.containsKey(a.getCountry())) {
	            Map<SocialClass, Integer> resa = res.get(a.getCountry());
	            if (resa.containsKey(a.getSocialClass())) {
	                resa.put(a.getSocialClass(), resa.get(a.getSocialClass()) + 1);
	            }
	            else {
	                resa.put(a.getSocialClass(), 1);
	            }
	            res.put(a.getCountry(), resa);
	        }
	        else {
	            Map<SocialClass, Integer> resa = new HashMap<>();
	            resa.put(a.getSocialClass(), 1);
	            res.put(a.getCountry(), resa);
	        }
	    }
	    return res;
	}
	
	//Returns a map with the countries and the number of people in each country
	//that have an income which is included in the range (income-250, income+250)
	public Map<String, Integer> countriesIncomeRange(Integer income){
		Map<String, Integer> res = new HashMap<>();
		for(User a: Users) {
			if((income-250)<=a.getSalary() && (income+250)>=a.getSalary()) {
					if(res.containsKey(a.getCountry())) {
						res.put(a.getCountry(), res.get(a.getCountry())+1);
					}
					else {
						res.put(a.getCountry(), 1);
					}
			}
		}
		return res;
	}
	
	
	//THIRD DELIVERY
	
	//BLOCK 1
	
	//Checks if exists a certain username in the database (STREAM)
	public Boolean checkUsernameStream(String username) {
		return Users.stream()
				.anyMatch(p -> p.getUsername().equals(username));
	}
	
	//Checks if all the users in the database are older than a given age (STREAM)
	public Boolean olderThanStream(Integer age) {
		return Users.stream()
				.allMatch(p -> p.getAge() >= age);
	}
	
	//Counts how many users with an iPhone have an income greater than a given value (STREAM)
	public long peopleWithGreaterIncomeStream(Integer income) {
		return Users.stream()
				.filter(x->x.getSalary()>=income)
				.count();
	}
	
	//Sum the total number of savings of the people (STREAM)
	public Integer savingsTotalStream() {
		return Users.stream()
				.mapToInt(x->x.getSavings())
				.sum();
	}
	
	//Compute the average income of the different ages
	public Map<Integer, Integer> averageSavingsAge() {
	    return Users.stream()
	            .collect(Collectors.groupingBy(User::getAge,
	                    Collectors.collectingAndThen(
	                            Collectors.averagingInt(User::getSavings),
	                            x -> (int) Math.round(x))));
	}	
				
	//Creates a list with the users from a certain country having more savings than a given number (STREAM)
	public List<String> usersCountryWithMoreSavingsThanStream(Integer savings, String country){
		return Users.stream()
				.filter(x->x.getSavings()>=savings && x.getCountry().equals(country))
				.map(x->x.getUsername())
				.collect(Collectors.toList());
	}
	
	//Creates a list with the users paying a mortgage from a given country (STREAM)
	public List<String> userMortgageStream(String country){
		return Users.stream()
				.filter(x->x.getMortgage().equals(true))
				.map(x->x.getUsername())
				.collect(Collectors.toList());
	}
	
	//Finds the user with the greater salary from a given country
	public Integer greaterSalaryCountry(String country) {
		return Users.stream()
				.filter(x->x.getCountry().equals(country))
				.max(Comparator.comparing(User::getSalary))
				.map(x->x.getSalary())
				.get();
	}
	
	//Creates a sorted list of users belonging to a given workclass by their salary
	public List<String> workclassList(String workclass){
		return Users.stream()
				.filter(x->x.getWorkclass().equals(workclass))
				.sorted(Comparator.comparingInt(User::getSalary))
				.map(User::getUsername)
				.collect(Collectors.toList());
				
	}
	
	//BLOCK 2
	
	//Returns a map that represents the marital status of the users from a given social class (STREAM)
	public Map<String, List<String>> usersMaritalStatusStream(SocialClass socialclass){
		return Users.stream()
				.filter(x->x.getSocialClass().equals(socialclass))
				.collect(Collectors.groupingBy(User::getMaritalStatus, Collectors.mapping(User::getUsername, Collectors.toList())));
		}
	
	//Returns a map that represents the average salary of the users of each education level
	public Map<String, Double> averageSalariesByEducation() {;
	    return Users.stream()
	        .collect(Collectors.groupingBy(User::getEducation,
	                Collectors.collectingAndThen(
	                    Collectors.averagingDouble(User::getSalary),
	                    x -> Math.round(x * 100.0) / 100.0)));
	}
	
	//Returns a map which shows the users of each gender in each country having the greatest salary
	public Map<String, Map<String, Integer>> maxSalaryByGender() {
	    return Users.stream()
	            .collect(Collectors.groupingBy(User::getCountry,Collectors.groupingBy(User::getSex, 
	                     Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(User::getSalary)),
	                     x -> x.map(User::getSalary).orElse(0)))));
	}
	
	//Returns a sorted map that shows the n youngest users paying or not paying a mortgage
	public SortedMap<Boolean, List<String>> youngestUsersMortgage(Integer n) {
	    return Users.stream()
	            .sorted(Comparator.comparingInt(User::getAge))
	            .collect(Collectors.groupingBy(User::getMortgage,
	                    TreeMap::new,
	                    Collectors.collectingAndThen(Collectors.toList(),x -> x.stream()
	                            .map(User::getUsername)
	                            .limit(n)
	                            .collect(Collectors.toList()))));
	}
	
	//Returns the most used smartphone among the users
	public String findMostSmartphone() {
	    Map<String, Long> res = Users.stream()
	            .collect(Collectors.groupingBy(x -> x.getOthers().get(0), Collectors.counting()));
	    
	    return res.entrySet().stream()
	    		.max(Map.Entry.comparingByValue())
	    		.get()
	    		.getKey();
	}
	
	
}
