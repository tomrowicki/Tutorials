import java.io.File;
import java.util.Scanner;


public class ReadFile {

	private Scanner scanner;
	
	public void OpenFile(){
		
		try{
			scanner = new Scanner(new File("test2.txt"));
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public void ReadFile(){
		while(scanner.hasNext()){ // allows for the reading of all lines
			String a = scanner.next(); // each string ends at the whiteline
			String b = scanner.next();
			String c = scanner.next();
			
			System.out.printf("%s %s %s\n", a, b, c);			
		}
	}
	
	public void CloseFile(){
		scanner.close();
	}
}
