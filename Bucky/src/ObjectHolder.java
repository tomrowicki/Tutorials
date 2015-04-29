
public class ObjectHolder {

	public static void main(String[] args) {

		ObjectHolderDogList dL = new ObjectHolderDogList();
		ObjectHolderDog d = new ObjectHolderDog();
		// dL.add(d);
		
		ObjectHolderAnimalList aL = new ObjectHolderAnimalList();
		ObjectHolderFish f = new ObjectHolderFish();
		// aL.add(f);
		// aL.add(d);
		
		ObjectHolderAnimal[] theList = new ObjectHolderAnimal[2];
		
		theList[0] = d;
		theList[1] = f;
		
		for(ObjectHolderAnimal x: theList) // iterate through the whole list
		{
			x.noise();
		}
		

	}

}
