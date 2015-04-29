import java.util.EnumSet;

public class Enumeration {
	public static void main(String args[]){
		for(Enu1 people: Enu1.values()){
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		}
		
		System.out.println("\nAnd now for the range of constants!!!\n");
		
		for(Enu1 people: EnumSet.range(Enu1.kelsey, Enu1.candy)){ // EnumSet allows for the designation of range of items
			System.out.printf("%s\t%s\t%s\n", people, people.getDesc(), people.getYear());
		}
	}

}
