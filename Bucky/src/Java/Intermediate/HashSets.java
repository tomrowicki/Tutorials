package Java.Intermediate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSets { // sets don't allow for duplicated entries

	public static void main(String[] args) {

		String[] things = {"apple", "bob", "ham", "bob", "bacon"};
		List<String> list = Arrays.asList(things);
		
		System.out.printf("%s", list);
		System.out.println();
		
		Set<String> set = new HashSet<String>(list);
		System.out.printf("%s ", set);
		
	}

}
