import java.awt.Color;
import java.awt.Graphics;


public class GravDown extends Item {

	public GravDown(int x) {
		super(x); // passing all information from the Item class constructor
	}
	
	@Override
	public void performAction(Ball b) {

		if (b.getGravity() > 3){ // gravity can't be below zero
			b.setGravity(b.getGravity() - 3);
			if (b.getGravity() < 3){ // checks the gravity value after subtraction
				b.setGravity(3);
			}
		}
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.GREEN);
		super.paint(g);
	}
}