package Java.Intermediate;

public class Recursion {

	public static void main(String[] args) {

		System.out.println(factorial(4));
	}
	
	public static long factorial(long n){ // silnia
		
		if (n<=1) // this is called a base case and it makes the loop stop
		{
			return 1;
		}
		else
		{
			return n * factorial(n-1);
		}
	}

}
