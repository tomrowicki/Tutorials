package Java.Intermediate;

public class StringsCommonMethods {

	public static void main(String[] args) {

		String[] words = {"funk", "chunk", "furry", "baconator"};
		
		//startsWith
		for (String w : words)
		{
			if(w.startsWith("fu"))
			{
				System.out.println(w + " starts with 'fu'");
			}
		}
		//endsWith
		for (String w : words)
		{
			if(w.endsWith("unk"))
			{
				System.out.println(w + " ends with 'unk'");
			}
		}
		
		String s = "buckyrobertsbuckyrobertsbuckyroberts";
		System.out.println(s.indexOf("k", 5)); // 2nd parameter is the starting point index, can be used for substrings
		
		
		String a = "Bacon ";
		String b = "monster";
		String c = "       cookie!     ";
		System.out.println(a.concat(b));
		System.out.println(a.replace("Ba", "ex-"));
		System.out.println(c.trim()); // removes all whitespaces
	}

}
