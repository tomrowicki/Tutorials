import java.awt.FlowLayout; // used for positioning
import javax.swing.JFrame; // windows gui elements
import javax.swing.JLabel; // output of text and images

public class GuiJFrame1 extends JFrame 
{

	private JLabel item1;
	
	public GuiJFrame1()
	{
		super("The title bar");
		setLayout(new FlowLayout());
		
		item1 = new JLabel("This is a sentence");
		item1.setToolTipText("This is gonna appear on hover");
		add(item1); // adding item to the window
	}
	
}
