import java.io.File;
import java.util.Formatter;


public class fileClass {

	public static void main(String[] args) {

		File file = new File("C:\\test.txt"); //  single backslashes are escape characters
		if (file.exists())
		{
			System.out.println(file.getName() + " exists!");
		}
		else
		{
			System.out.println("the freakin' thing doesn't exist!");
		}
		
		final Formatter formatter; // formatter allows for writing to a file
		
		try
		{
			formatter = new Formatter("C:\\test1.txt"); // if file doesn't exist, it gets created
			System.out.println("A file is created!");
		}
		catch(Exception e)
		{
			System.out.println("You got an error: " + e);
		}
	}

}
