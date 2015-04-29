package Java.Intermediate;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class DrawOval extends JPanel {
	
	private int d = 10;
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		g.fillOval(10, 10, d, d);
				
	}
	
	public void setD(int newD){
		d = (newD >= 0 ? newD : 10); //if (newD>=0) d = newD else d = 10
		repaint(); // don't need to call paintComponent method over and over again
	}
	
	public Dimension getPreferredSize(){
		return new Dimension(200, 200);
	}
	
	public Dimension getMinimumSize(){
		return getPreferredSize();
	}

}
