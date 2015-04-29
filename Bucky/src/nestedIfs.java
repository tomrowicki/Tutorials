
public class nestedIfs {
	public static void main(String args[]){
		int age = 70;
		
		if(age < 50){
			System.out.println("You are young");
		} else{
			System.out.println("You are old");
			if(age > 75){
				System.out.println("You are REALLY old!");
			}
		}
	}
}
