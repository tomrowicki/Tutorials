import java.util.Scanner;

public class methodsInstances {
	public static void main(String args[]){
		Scanner input = new Scanner(System.in);
		tuna3 tunaObject = new tuna3();
		System.out.println("Enter name of first gf here: ");
		String temp = input.nextLine();
		tunaObject.setName(temp);
		tunaObject.saying();
	}
}
