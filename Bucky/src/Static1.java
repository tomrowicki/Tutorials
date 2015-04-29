
public class Static1 {
	private String first;
	private String last;
	private static int members = 0; // static means that every object shares this variable, once it changes, it changes in all objects
	
	public Static1(String fn, String ln){
		first = fn;
		last = ln;
		members++;
		System.out.printf("Constructor for %s %s, members in the club: %d\n", first, last, members);
	}
	public String getFirst(){
		return first;
	}
	public String getLast(){
		return last;
	}
	public static int getMembers(){
		return members;
	}
}
