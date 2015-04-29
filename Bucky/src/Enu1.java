
public enum Enu1 { // enumerated list
	bucky("nice", "22"),
	kelsey("cutie", "10"),
	julia("bigmistae", "12"),
	nicole("italian", "13"),
	candy("different", "14"),
	erin("iwish", "16");
	
	private final String desc;
	private final String year;
	
	Enu1(String description, String age){
		desc = description;
		year = age;
	}
	
	public String getDesc(){
		return desc;
	}
	
	public String getYear(){
		return year;
	}
}
