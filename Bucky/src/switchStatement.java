
public class switchStatement {
	public static void main(String args[]){
		int age;
		age = 3;
		
		switch (age){ // an alternative to if statements
		case 1:
			System.out.println("You can crawl");
			break;
		case 2:
			System.out.println("You can talk");
			break;
		case 3:
			System.out.println("You can get in trouble");
			break;
		default:
			System.out.println("I dunno how old you are");
			break;
		}
	}
}
