
public class multipleConstructors {
	public static void main(String args[]){
		tuna5 tunaObject = new tuna5();
		System.out.println(tunaObject.toMilitary());
		
		tuna5 tunaObject2 = new tuna5(5);
		tuna5 tunaObject3 = new tuna5(5,13);
		tuna5 tunaObject4 = new tuna5(5,13,26);
		System.out.println(tunaObject2.toMilitary());
		System.out.printf("%s\n", tunaObject3.toMilitary()); // this printf style i basically println (string + newline)
		System.out.printf("%s\n", tunaObject4.toMilitary());


	}
}
