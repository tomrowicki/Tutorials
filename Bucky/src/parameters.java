import java.util.Scanner;

public class parameters {
	public static void main (String args[]){
		Scanner input = new Scanner(System.in);
		tuna1 tunaObject1 = new tuna1();
		System.out.println("Enter your name here: ");
		String name = input.nextLine();
		tunaObject1.simpleMessage(name);
	}

}
