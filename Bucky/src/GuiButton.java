import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class GuiButton extends JFrame {
	
	private JButton reg;
	private JButton custom;
	
	public GuiButton()
	{
		super("The title"); // uses the JFrame constructor
		setLayout (new FlowLayout());
		
		reg = new JButton("reg button"); // "reg" stands for regular
		add(reg);
		
		Icon b = new ImageIcon(getClass().getResource("pobrane.png"));
		Icon x = new ImageIcon(getClass().getResource("button1.png"));
		custom = new JButton("Custom", x);
		custom.setRolloverIcon(b);
		//custom.setRolloverEnabled(true);
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
		
	}
	
	private class HandlerClass implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
		}
	}

}
