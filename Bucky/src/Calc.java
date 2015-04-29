import java.util.Scanner;

class Calc {
	public static void main(String args[]){
		Scanner bucky = new Scanner(System.in);
		double fnum, snum, answer; // declaring multiple vars in 1 line
		System.out.println("Enter first num: ");
		fnum = bucky.nextDouble();
		System.out.println("Enter second num: ");
		snum = bucky.nextDouble();
		answer = fnum / snum;
		System.out.println("Answer: " + answer);
	}
}
