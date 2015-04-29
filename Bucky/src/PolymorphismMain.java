
public class PolymorphismMain {

	public static void main(String[] args)
	{
		Polymorphism poly = new Polymorphism1(); // creating in a polymorphic, sorta, way
		
		Polymorphism poly1[] = new Polymorphism[2]; // array of objects
		poly1[0] = new Polymorphism1();
		poly1[1] = new Polymorphism2();
		
		for (int x=0; x<2; x++)
		{
			poly1[x].eat(); // initiating methods of all objects, no matter the class
		}
		
		Polymorphism3 poly2 = new Polymorphism3();
		Polymorphism poly3 = new Polymorphism2();
		
		poly2.digest(poly3);

	}

}
