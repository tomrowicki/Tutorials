
public class enhancedFor { // sums up all elements in array
	public static void main(String args[]){
		int bucky[] = {3,4,5,6,7};
		int total = 0;
	
		for (int x: bucky){ // works like for each in Python
			total += x;
		}
		
		System.out.println(total);
	}

}
