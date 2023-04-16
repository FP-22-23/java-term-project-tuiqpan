package fp.adults;

public record Others(String smartphone, String car) {
	
	public Others(String smartphone, String car) {
		this.smartphone = smartphone;
		this.car = car;
	}
	
	public String getShortFormat() {
		return "Smartphone= " + smartphone + ", Car= " + car; 
	}
}
