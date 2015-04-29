package Java.Intermediate;

import java.util.Random;

public class Threads implements Runnable {
	
	String name;
	int time;
	Random r = new Random();
	
	public Threads(String x)
	{
		name = x;
		time = r.nextInt(999); // random time between 0 and 999 ms
	}
	
	public void run() {

		try
		{
			System.out.printf("%s is sleeping for %d\n", name, time);
			Thread.sleep(time);
			System.out.printf("%s is done\n", name);
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	

}
