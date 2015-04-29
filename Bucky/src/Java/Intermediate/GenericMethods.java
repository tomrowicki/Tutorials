package Java.Intermediate;

public class GenericMethods {

	public static void main(String[] args) {

		Integer[] iray = {1, 2, 3, 4};
		Character[] cray = {'b', 'u', 'c', 'k', 'y'};
		
		printMe(iray);
		printMe(cray);
	}
	
//	public static void printMe (Integer[] i){ // sucky way
//		for (Integer x : i)
//		{
//			System.out.printf("%s ", x);
//		}
//		System.out.println();
//	}
//	
//	public static void printMe (Character[] c){ // sucky sucky
//		for (Character x : c)
//		{
//			System.out.printf("%s ", x);
//		}
//		System.out.println();
//	}
	
	// a good way to tackle multiple data types is through generic methods
	
	public static <T> void printMe(T[] x){ // "T" used conventionally
		for(T b : x)
		{
			System.out.printf("%s ", b);
		}
		System.out.println();
	}
	

}
