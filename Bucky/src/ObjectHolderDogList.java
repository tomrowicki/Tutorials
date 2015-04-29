
public class ObjectHolderDogList {
	
	private ObjectHolderDog[] theList = new ObjectHolderDog[5];
	private int i = 0;
	
	public void add(ObjectHolderDog d)
	{
		if(i<theList.length)
		{
			theList[i] = d;
			System.out.println("Dog added at index " + i);
			i++;
		}
	}

}
