
public class potpie { // used by toString.java
	private int month;
	private int day;
	private int year;
	
	public potpie(int m, int d, int y){
		month = m;
		day = d;
		year = y;
		
		System.out.printf("The constructor for this is %s\n", this); // this refers to the last object processed (toString here)
	}
	
	public String toString(){
		return String.format("%d/%d/%d", month, day, year);
	}
}
