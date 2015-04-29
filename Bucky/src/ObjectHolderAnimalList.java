
public class ObjectHolderAnimalList 
{
	private ObjectHolderAnimal[] theList = new ObjectHolderAnimal[5];
	private int i = 0;
	
	public void add(ObjectHolderAnimal a)
	{
		if(i<theList.length)
		{
			theList[i] = a;
			System.out.println("Animal added at index "+i);
			i++;
		}
	}
}
