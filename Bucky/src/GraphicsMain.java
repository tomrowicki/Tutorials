import javax.swing.JFrame;


public class GraphicsMain {

	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GraphicsTut gfx = new GraphicsTut();
		f.add(gfx);
		f.setSize(400, 250);
		f.setVisible(true);
		
	}

}
