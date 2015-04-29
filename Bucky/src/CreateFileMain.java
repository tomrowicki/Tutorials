
public class CreateFileMain {

	public static void main(String[] args) {

		createFile file = new createFile();
		file.OpenFile();
		file.AddRecords();
		file.CloseFile();
	}

}
