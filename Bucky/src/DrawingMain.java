import java.awt.Color;

import javax.swing.JFrame;


public class DrawingMain {

	public static void main(String[] args) {

		JFrame jf = new JFrame();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Drawing drawing = new Drawing();
		drawing.setBackground(Color.WHITE);
		jf.add(drawing);
		jf.setSize(500, 270);
		jf.setVisible(true);
		
	}

}
