import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;


public class GraphicsTut extends JPanel {

	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
		
		g.setColor(Color.BLUE);
		g.fillRect(25, 25, 100, 30);
		
		g.setColor(new Color(190, 81, 215)); // setting a custom colour using RGB standard
		g.fillRect(25, 65, 100, 30);
		
		g.setColor(Color.RED);
		g.drawString("This is a random text", 25, 120);
	}
}
