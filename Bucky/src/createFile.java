import java.util.Formatter;


public class createFile {

	private Formatter formatter;
	
	public void OpenFile(){
		try
		{
			formatter = new Formatter("test2.txt");
		}
		catch (Exception e)
		{
			System.out.println("You have an error " + e);
		}		
	}
	
	public void AddRecords(){ // adding data to a file
		
		formatter.format("%s%s%s", "20 ", "Bucky ", "Roberts");
		
	}
	
	public void CloseFile(){
		formatter.close();
	}
	
}
