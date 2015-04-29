
public class Final1 {
	private int sum;
	private final int NUMBER; // constant with value initialised via constructor


	public Final1(int x){
		NUMBER = x;
	}
	public void add(){
		sum+=NUMBER;
	}
	public String toString(){
		return String.format("sum = %d\n", sum);
	}
}