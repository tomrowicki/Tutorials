package Java.Intermediate;

public class ThreadsMain {

	public static void main(String[] args) {

		Thread t1 = new Thread(new Threads("one"));
		Thread t2 = new Thread(new Threads("two"));
		Thread t3 = new Thread(new Threads("three"));
		Thread t4 = new Thread(new Threads("four"));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();

	}

}
