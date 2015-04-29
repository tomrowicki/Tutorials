
public class arrayTable {
	public static void main(String args[]){
		System.out.println("Index\tValue");
		int bucky[] = {5,1,22,6,77};
		
		for(int counter=0;counter<bucky.length;counter++){
			System.out.println(counter + "\t" + bucky[counter]);
		}
		
		int sum = 0;
		for(int counter=0;counter<bucky.length;counter++){
			sum+=bucky[counter];
		}
		System.out.println("The sum of all elements is: " + sum);
	}
}
