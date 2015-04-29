import java.util.Scanner;


public class ExceptionHandling {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int x = 1;
		
		do{ //Ensure the typing in of the valid input
		try{
			System.out.println("Enter first number: ");
			int n1 = input.nextInt();
			System.out.println("Enter second number: ");
			int n2 = input.nextInt();
			int sum = n1/n2;
			System.out.println(sum);
			x = 2;
		}
		catch(Exception e){
			System.out.println("You can't do that.\n" + e);
		}

		}while (x==1);

	}
}
