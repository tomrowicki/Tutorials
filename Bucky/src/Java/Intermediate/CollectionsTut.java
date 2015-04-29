package Java.Intermediate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class CollectionsTut {

	public static void main(String[] args) {

		String[] array = {"eggs", "lasers", "hats", "pie"};
		List<String> list = new ArrayList();
		
		// adding array items to a list
		for (String s : array)
		{
			list.add(s);
		}
		
		String[] secondArray = {"eggs", "hats"};
		List<String> list2 = new ArrayList();
		
		for (String s2 : secondArray)
		{
			list2.add(s2);
		}
		
		editList(list, list2);
		System.out.println();
		
		for (int i=0; i<list2.size(); i++){
			System.out.printf("%s ", list.get(i));
		}
	}
	
	public static void editList(Collection<String> list1, Collection<String> list2){
		
		Iterator<String> it = list1.iterator();
		while (it.hasNext())
		{
			if(list2.contains(it.next())) // checks is list2 contains the item we're currently checking through the iterator
			{
				it.remove(); // removes the item being checked
			}
		}
		
	}
}
