import java.awt.Color;
import java.awt.Graphics;


public class GravUp extends Item{

	public GravUp(int x) {
		super(x); // passing all information from the Item class constructor
	}
	
	@Override
	public void performAction(Ball b) {

		b.setGravity(b.getGravity() + 3);
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(Color.RED);
		super.paint(g);
	}
}
