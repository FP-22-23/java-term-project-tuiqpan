package fp.adults;

import java.util.Objects;

public class Others {
	
	private String smartphone;
	private String car;
	private String sport;
	
	public Others() {
		
	}
	
	public Others(String smartphone, String car, String sport) {
		this.smartphone = smartphone;
		this.car = car;
		this.sport = sport;
	}

	public String getSmartphone() {
		return smartphone;
	}

	public void setSmartphone(String smartphone) {
		this.smartphone = smartphone;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String car) {
		this.car = car;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	@Override
	public int hashCode() {
		return Objects.hash(car, smartphone, sport);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Others other = (Others) obj;
		return Objects.equals(car, other.car) && Objects.equals(smartphone, other.smartphone)
				&& Objects.equals(sport, other.sport);
	}

	@Override
	public String toString() {
		return "[smartphone=" + smartphone + ", car=" + car + ", sport=" + sport + "]";
	}
	
	
}
