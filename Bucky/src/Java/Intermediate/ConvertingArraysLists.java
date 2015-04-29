package Java.Intermediate;

import java.util.Arrays;
import java.util.LinkedList;

public class ConvertingArraysLists {

	public static void main(String[] args) {

		String[] stuff = {"watermelon", "melon", "baby", "fudge"};
		LinkedList<String> theList = new LinkedList<String>(Arrays.asList(stuff));
		
		theList.add("pumpkin"); // adding to the back
		theList.addFirst("first thing"); // adding to the front
		
		// convert back to array
		stuff = theList.toArray(new String[theList.size()]);
		
		for (String s : stuff)
		{
			System.out.printf("%s ", s);
		}
	}

}
