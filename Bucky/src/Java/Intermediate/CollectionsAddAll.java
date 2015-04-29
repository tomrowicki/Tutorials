package Java.Intermediate;

import java.util.*;

public class CollectionsAddAll {

	public static void main(String[] args) {

		String[] stuff = {"apples", "beef", "corn", "ham"};
		List<String> l1 = Arrays.asList(stuff);
		
		ArrayList<String> l2 = new ArrayList<String>(); // arrays have particular sizes, whereas arraylists are dynamic
		l2.add("youtube");
		l2.add("google");
		l2.add("coursera");
		
		for (String s : l2)
		{
			System.out.printf("%s ", s);
		}
		
		Collections.addAll(l2, stuff);
		System.out.println();
		
		for (String s : l2)
		{
			System.out.printf("%s ", s);
		}
		System.out.println();
		
		System.out.println(Collections.frequency(l2, "youtube"));
		
		boolean truefalse = Collections.disjoint(l1, l2); // returns true if the two lists have no items in common
		System.out.println(truefalse);
		
		if (truefalse)
		{
			System.out.println("These lists have no items in common.");
		}
		else
		{
			System.out.println("These lists have items in common.");
		}
	}

}
