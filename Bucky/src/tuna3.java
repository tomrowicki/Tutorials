
public class tuna3 {
	private String girlName;
	
	public tuna3 (String name){ // constructor method
		girlName=name;
	}
	public tuna3 (){ // constructor method
		girlName = "wtf";
	}
	public void setName(String name){
		girlName = name;		
	}
	public String getName(){
		return girlName;
	}
	public void saying(){
		System.out.printf("Your first gf was %s\n", getName());
	}
}
