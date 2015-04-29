import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EventHandling1 extends JFrame
{
	private JTextField item1;
	private JTextField item2;
	private JTextField item3;
	private JPasswordField passwordField;
	
	public EventHandling1()
	{
		super("The title");
		setLayout(new FlowLayout());
		
		item1 = new JTextField(10); // 10 is the length of the field
		add(item1);
		item2 = new JTextField("Enter text here:"); // default length
		add(item2);
		item3 = new JTextField("Uneditable", 20);
		item3.setEditable(false);
		add(item3);
		
		passwordField = new JPasswordField("mypass"); // displayed in asterisks
		add(passwordField);
		
		thehandler handler = new thehandler();
		item1.addActionListener(handler);
		item2.addActionListener(handler);
		item3.addActionListener(handler);
		passwordField.addActionListener(handler);
	}
	
	private class thehandler implements ActionListener{ // class built inside another class inherits the latter's crap
	
		public void actionPerformed(ActionEvent event){
			
			String string = "";
			
			if(event.getSource()==item1) // enter is hit in the first text field
			{
				string = String.format("field 1: %s", event.getActionCommand());
			}
			else if(event.getSource()==item2) // enter is hit in the first text field
			{
				string = String.format("field 2: %s", event.getActionCommand());
			}
			else if(event.getSource()==item3) // enter is hit in the first text field
			{
				string = String.format("field 3: %s", event.getActionCommand());
			}
			else if(event.getSource()==passwordField)
			{
				string = String.format("password field is: %s", event.getActionCommand());
			}
			
			JOptionPane.showMessageDialog(null, string); // generates a window
		}
	}
}
