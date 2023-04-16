package fp.adults;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Adults {
	
	
	private List<Adult> Adults;
	
	
	//Collection of adults using stream (Type Adults)
	public Adults(Stream<Adult> ad) {
		Adults = ad.collect(Collectors.toList());
	}
	
	//Collection of Adults (Type Adults)
	public Adults(Collection<Adult> ad) {
		Adults = new ArrayList<Adult>(ad);
	}
	
	//Empty collection of adults 
	public Adults() {
		Adults = new ArrayList<Adult>();
	}

	//Gets the size of the database
	public Integer getAdultos() {
		return Adults.size();
	}
	
	//Getter
	public List<Adult> getRegisters() {
		return Adults;
	}

	//Adds a register
	public void add(Adult adult) {
		Adults.add(adult);
	}
	
	//Remove a register
    public void remove(Adult adult) {
    	Adults.remove(adult);
    }
    
	@Override
	public String toString() {
		return "Adults [registers=" + Adults + "]";
	}
	
	//Methods
	
	//Checks if there is an certain username in the database
	public Boolean checkUsername(String username) {
		Boolean res = false;
		for(Adult a : Adults) {
			if(a.getUsername().equals(username)) {
				res = true;
			}
		}
		return res;
	}
	
	//Check if all the adults in the database are older than a given age 
	public Boolean olderThan(Integer age) {
		Boolean res = true;
		for(Adult a : Adults) {
			if(a.getAge()<=age) {
				res = false;
				break;
			}
		}
		return res;
	}
	
	//Counts how many people with an iPhone have an income greater than a given value

	public Integer peopleWithGreaterIncome(Integer income) {
		Integer res = 0;
		for(Adult a: Adults) {
			if(a.getSalary()>=(income)) {
					res ++;
			}
		}
	return res;
	}
	
	//Sum the total number of savings of the people
	public Integer savingsTotal() {
		Integer res = 0;
		for(Adult a: Adults) {
				res += a.getSavings();
				
			}
	return res;
	}
	
	//Compute the average income of the people in the database in a given country
	public Integer averageIncomePerCountry(String country) {
	    Integer res = 0;
	    Integer count = 0;
	    for(Adult a: Adults) {
	        if(a.getCountry().equalsIgnoreCase(country)) {
	            res += a.getSalary();
	            count++;
	        }
	    }
	    return res/count;
	}
	
	//Filtering
	
	//Creates a list with the users from a certain country having more savings than a given number
	public List<String> usersCountryWithMoreSavingsThan(Integer savings, String country){
		List<String> res = new ArrayList<>();
		for(Adult a: Adults) {
			if(a.getSavings()>savings && a.getCountry().equals(country)) {
				res.add(a.getUsername());
			}
		}
		return res;
	}
	
	//Creates a list with the users paying a mortgage
	public List<String> userMortgage(){
		List<String> res = new ArrayList<>();
		for(Adult a: Adults) {
			if(a.getMortgage().equals(true)) {
				res.add(a.getUsername());
			}
		}
		return res;
	}
	
	//Returns a map that returns the represents the marital status of each user
	public Map<String, List<String>> usersMaritalStatus(){
		Map<String, List<String>> res = new HashMap<>();
		for(Adult a : Adults) {
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
	
	//Returns a map that represents the number of people belonging to each social class
	//in each country
	public Map<String, Map<SocialClass, Integer>> countriesSocialClass() {
	    Map<String, Map<SocialClass, Integer>> res = new HashMap<>();
	    for (Adult a : Adults) {
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
		for(Adult a: Adults) {
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
 
	
	@Override
	public int hashCode() {
		return Objects.hash(Adults);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adults other = (Adults) obj;
		return Objects.equals(Adults, other.Adults);
	}
	
	
} 
