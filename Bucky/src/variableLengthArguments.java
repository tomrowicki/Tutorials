
public class variableLengthArguments {
	public static void main(String args[]){
		System.out.println(average(43,55,23,64)); // any number of arguments can be provided here
	}
	
	public static int average(int...numbers){ // ... indicates there's a varied number of arguments
		int total = 0;
		for (int x:numbers){
			total+=x;
		}
		return total/numbers.length;
	}
}
