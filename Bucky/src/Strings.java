
/**
 * @author Tomasz
 *
 */
public class Strings {

	public static void main(String[] args) {

		String a = "apples";
		String b = "bucky";
		String c = "BUCKY";
		
		System.out.println(a.length());
		if(a.equals("apples")){ // "==" determines if two instances are of the same object, if they are not, even though their values are the same, they'll be evaluated as different
			System.out.println("It equals apples!");
		}
		if(b.equals(c)){
			System.out.println("Variables match!");
		}
		if(b.equalsIgnoreCase(c)){
			System.out.println("aaand now they match!");
		}
	}

}