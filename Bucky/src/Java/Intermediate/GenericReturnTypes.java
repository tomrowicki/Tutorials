package Java.Intermediate;

public class GenericReturnTypes {

	public static void main(String[] args) {

		System.out.println(max(23, 42, 1));
		System.out.println(max("bananas", "zuccini", "apples"));
	}
	
	public static <T extends Comparable<T>> T max(T a, T b, T c){ // only objects of comparable type (extending Comparable<T>) can be used here 
	
		T m = a; // "m" stands for maximum
	
		if(b.compareTo(a) > 0)
		{
			m = b;
		}
	
		if(c.compareTo(m) > 0)
		{
			m = c;
		}
		
		return m;
	}
}
