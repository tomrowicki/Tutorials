import java.awt.FlowLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class ComboBox extends JFrame {
	
	private JComboBox box;
	private JLabel picture;
	
	private static String[] filename = {"button1.png", "pobrane.png"};
	private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0])), new ImageIcon(getClass().getResource(filename[1]))};
	
	public ComboBox(){
		super("the title");
		setLayout(new FlowLayout());
		
		box = new JComboBox(filename); // parameter for options
		
		box.addItemListener( // usage of an anonymous interclass
				new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange()==ItemEvent.SELECTED){
							picture.setIcon(pics[box.getSelectedIndex()]);
						}
					}
				}
		);
		
		add(box);
		picture = new JLabel(pics[0]);
		add(picture);
	}

}
