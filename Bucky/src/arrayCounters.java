import java.util.Random;

public class arrayCounters { // counting face values when rolling a dice 1000 times
	public static void main(String argsp[]){
		Random rand = new Random();
		int frequencyArray[] = new int[7];
		
		for(int roll=1;roll<1000;roll++){
			++frequencyArray[1+rand.nextInt(6)]; // numbers 0-5 + 1
		}
		
		System.out.println("Face\tFrequency");
		
		for(int face=1;face<frequencyArray.length;face++){
			System.out.println(face + "\t" + frequencyArray[face]);
		}
	}	
}
