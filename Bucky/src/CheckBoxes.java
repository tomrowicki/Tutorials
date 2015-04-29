import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;


public class CheckBoxes extends JFrame {
	
	private JTextField tf;
	private JCheckBox boldBox;
	private JCheckBox italicBox;
	
	public CheckBoxes()
	{
		super("The title");
		setLayout(new FlowLayout());
		
		tf = new JTextField("This is a sentence", 20);
		tf.setFont(new Font("Serif", Font.PLAIN, 14));
		add(tf);
		
		boldBox = new JCheckBox("bold");
		italicBox = new JCheckBox("italic");
		add(boldBox);
		add(italicBox);
		
		HandlerClass handler = new HandlerClass();
		boldBox.addItemListener(handler);
		italicBox.addItemListener(handler);

	}
	
	private class HandlerClass implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent event) {
			Font font = null;
			
			if(boldBox.isSelected() && italicBox.isSelected())
			{
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
			}
			else if(boldBox.isSelected())
			{
				font = new Font("Serif", Font.BOLD, 14);
			}
			else if(italicBox.isSelected())
			{
				font = new Font("Serif", Font.ITALIC, 14);
			}
			else
			{
				font = new Font("Serif", Font.PLAIN, 14);
			}
			
			tf.setFont(font);
			
		}
		
	}
}
