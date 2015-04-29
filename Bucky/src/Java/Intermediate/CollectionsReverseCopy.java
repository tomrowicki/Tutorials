package Java.Intermediate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionsReverseCopy {

	public static void main(String[] args) {

		Character[] array = {'p', 'w', 'n'}; // characters require single quotation marks
		List<Character> l = Arrays.asList(array);
		System.out.println("List is: ");
		output(l);
		
		// reverse and print out the list
		Collections.reverse(l);
		System.out.println("After reverse: ");
		output(l);
		
		// new array and new list
		Character[] newArray = new Character[3];
		List<Character> lcopy = Arrays.asList(newArray);
		
		// copy contents of l to lcopy
		Collections.copy(lcopy, l);
		System.out.println("Copy of list: ");
		output(lcopy);
		
		// fill collection with crap
		Collections.fill(l, 'X'); // works like replace
		System.out.println("After filling the list: ");
		output(l);
	}
	
	private static void output(List<Character> theList){
		
		for (Character ch : theList)
		{
			System.out.printf("%s ", ch);
		}
		System.out.println();
	}
	

}
