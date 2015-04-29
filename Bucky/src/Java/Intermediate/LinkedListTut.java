package Java.Intermediate;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class LinkedListTut {

	public static void main(String[] args) {

		String[] things = {"apples", "bananas", "pears", "oranges", "lemons"};
		List<String> list1 = new ArrayList();
		
		for (String s : things)
		{
			list1.add(s);
		}
		
		String[] things2 = {"sausage", "bacon", "goats", "harrypotter"};
		List<String> list2 = new ArrayList();
		
		for (String s : things2)
		{
			list2.add(s);
		}
		
		list1.addAll(list2);
		list2 = null;
		
		printMe(list1);
		removeStuff(list1, 2,5);
		printMe(list1);
		reverseMe(list1);
	}
	
	private static void printMe(List<String> l){
		
		for (String s : l)
		{
			System.out.printf("%s ", s);
		}
		System.out.println();
	}
	
	private static void removeStuff(List<String> l, int from, int to){
		
		l.subList(from, to).clear(); // clearing a specified portion of a list
	}
	
	private static void reverseMe(List<String> l){
		ListIterator<String> listIterator = l.listIterator(l.size()); // the end of a list is the starting point for the iterator
		while (listIterator.hasPrevious()){
			System.out.printf("%s ", listIterator.previous());
		}
	}

}
