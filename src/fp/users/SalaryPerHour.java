package fp.users;

import fp.utils.Checkers;

import java.util.Objects;

public class SalaryPerHour implements Comparable<SalaryPerHour>{
	
	
	//ATTRIBUTES
	
	private Integer salary;
	private Double hours;

	
	//CONSTRUCTORS
	
	public SalaryPerHour(Integer income, Double hours) {
		Checkers.check("Salary must be more than 0$", income>0);
		Checkers.check("Hours must be greater than 0 and less or equal to 40", (hours <= 40 && hours >= 0));
		this.salary = income;
		this.hours = hours;
		
	}
	
	public SalaryPerHour() {
		salary=0;
		hours=0.0;
	}
	
	//GETTERS AND SETTERS
	
	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public Double getHours() {
		return hours;
	}

	public void setHours(Double hours) {
		this.hours = hours;
	}
	
	public Double getIncomePerHour() {
	    double income = (getSalary() / 4) / getHours();
	    return Math.round(income * 100.0) / 100.0;
	}
	
	//HASHCODE AND EQUALS
	
	
	@Override
	public int hashCode() {
		return Objects.hash(hours, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SalaryPerHour other = (SalaryPerHour) obj;
		return Objects.equals(hours, other.hours) && Objects.equals(salary, other.salary);
	}
	
	
	//COMPARETO

	public int compareTo(SalaryPerHour o) {
		int res;
		res = this.getSalary().compareTo(o.getSalary());
		if (res == 0) {
			res = this.getHours().compareTo(o.getHours());	
		}
		return res;
	}


	//TOSTRING
	
	@Override
	public String toString() {
		return "Salary per hour=" + getIncomePerHour();
	}
	
	
	
	
	
}
