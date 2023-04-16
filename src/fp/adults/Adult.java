package fp.adults;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import fp.utils.Checkers;

public class Adult implements Comparable<Adult>{
	
	
	//ATTRIBUTES
	private LocalDate dateOfBirth;
	private String  username, workclass, education, maritalStatus, sex, country ;
	private Integer savings, salary;
	private Boolean mortgage;
	private List<Others> others;
	private SalaryPerHour salaryPerHour;
	
	
	//CONSTRUCTORS
	public Adult(String username, LocalDate dateOfBirth, String workclass, String education, String maritalStatus, String sex, String country,
			Boolean mortgage, Integer savings, Integer salary, SalaryPerHour salaryPerHour, List<Others> others) {

		Checkers.check("Savings must be more than 0$", savings>0);
		Checkers.check("The date of birth must be after (1960, 1, 1) and before (2000, 1, 1)", 
				dateOfBirth.isAfter(LocalDate.of(1960, 1, 1)) && dateOfBirth.isBefore(LocalDate.of(2000, 1, 1)));
		
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.workclass = workclass;
		this.education = education;
		this.maritalStatus = maritalStatus;
		this.sex = sex;
		this.country = country;
		this.mortgage = mortgage;
		this.savings = savings;
		this.salary = salary;
		this.salaryPerHour = salaryPerHour;
		this.others = others;
	}

	public Adult(String username,LocalDate dateOfBirth, Integer savings, Integer salary, SalaryPerHour salaryPerHour ) {

		Checkers.check("Savings must be more than 0$", savings>0);
		Checkers.check("The date of birth must be after (1960, 1, 1) and before (2000, 1, 1)",
				dateOfBirth.isAfter(LocalDate.of(1960, 1, 1)) && dateOfBirth.isBefore(LocalDate.of(2000, 1, 1)));
		
		
		this.username = username;
		this.dateOfBirth = dateOfBirth;
		this.workclass = "Unknown";
		this.education = "Unknown";
		this.maritalStatus = "Unknown";
		this.sex = "Unknown";
		this.country = "Unknown";
		this.mortgage = null;
		this.savings = savings;
		this.salary = salary;
		this.salaryPerHour = salaryPerHour;
		this.others = null;
	}
	

	//TOSTRING
	@Override
	public String toString() {
		return "Adult [Username="+username+", Age=" + getAge() + ", Workclass=" + workclass + ", Education=" + education + ", MaritalStatus=" + maritalStatus
				+ ", Sex=" + sex + ", Country=" + country + ", Savings=" + savings +
				", Salary=" + salary +  ", "+ salaryPerHour + ", Mortgage=" + mortgage+ ", Others=" + others + " Social class= " + getSocialClass()+ "]" ;
	}
	
	
	//GETTERS AND SETTERS
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getWorkclass() {
		return workclass;
	}

	public void setWorkclass(String workclass) {
		this.workclass = workclass;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Integer getSavings() {
		return savings;
	}

	public void setSavings(Integer savings) {
		this.savings = savings;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Boolean getMortgage() {
		return mortgage;
	}

	public void setMortgage(Boolean mortgage) {
		this.mortgage = mortgage;
	}

	public List<Others> getOthers() {
		return others;
	}

	public void setOthers(List<Others> others) {
		this.others = others;
	}

	public SalaryPerHour getSalaryPerHour() {
		return salaryPerHour;
	}

	public void setSalaryPerHour(SalaryPerHour salaryPerHour) {
		this.salaryPerHour = salaryPerHour;
	}
	
	
	//DERIVED PROPERTIES
	public Integer getAge() {
		return getDateOfBirth().until(LocalDate.now()).getYears();
	}
	
	public SocialClass getSocialClass() {
		if(getSalary()<500) {
			return SocialClass.LOWER;
		}
		else if (getSalary()<1300) {
			return SocialClass.WORKING;
		}
		else if (getSalary()<2000) {
			return SocialClass.MIDDLE;
		}
		else {
			return SocialClass.UPPER;
		}
	}
	
	
	//HASHCODE AND EQUALS
	@Override
	public int hashCode() {
		return Objects.hash(country, dateOfBirth, education, sex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof Adult))
			return false;
		Adult other = (Adult) obj;
		return Objects.equals(country, other.country) && Objects.equals(dateOfBirth, other.dateOfBirth)
				&& Objects.equals(education, other.education) && Objects.equals(sex, other.sex);
	}
	

	//COMPARE TO AND NATURAL ORDER
	public int compareTo(Adult s) {
		int res = 0;
		if(res==0) {
			res = this.getSalary().compareTo(s.getSalary());
			if(res==0){
				res = this.getSavings().compareTo(s.getSavings());
			}
		}
	return res;
	}


}
