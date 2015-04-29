
public class bacon { // used by toString.java
	private String name;
	private potpie birthday;
	
	public bacon(String theName, potpie theDate){
		name = theName;
		birthday = theDate;
	}
	
	public String toString(){
		return String.format("My name is %s, my birthday is %s", name, birthday); // 1st %s refers to name and 2nd to bday
	}
}
