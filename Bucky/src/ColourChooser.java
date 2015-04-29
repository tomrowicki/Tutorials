import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class ColourChooser extends JFrame {

	private JButton button;
	private Color color = (Color.WHITE);
	private JPanel panel;
	
	public ColourChooser(){
		super("title");
		panel = new JPanel();
		panel.setBackground(color);
		button = new JButton("Choose a colour");
		button.addActionListener(
				new ActionListener(){
					@Override
					public void actionPerformed(ActionEvent event){
						color = JColorChooser.showDialog(null, "Pick your colour", color); // position, info, colour
						if (color == null)
						{
							color = (Color.WHITE);
						}
						panel.setBackground(color);
					}

				}
		);
		add(panel, BorderLayout.CENTER);
		add(button, BorderLayout.SOUTH);
		setSize(425, 150);
		setVisible(true);
	}
}
