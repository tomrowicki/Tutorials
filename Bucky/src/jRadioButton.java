import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class jRadioButton extends JFrame { // when one button's pressed, the others get unpressed, as in old radios :)

	private JTextField tf;
	private Font pf; // plain
	private Font bf; // bold
	private Font itf; // italic 
	private Font bif; // bold italic
	private JRadioButton pb;
	private JRadioButton bb;
	private JRadioButton ib;
	private JRadioButton bib;
	private ButtonGroup group;

	public jRadioButton()
	{
		super("the title");
		setLayout(new FlowLayout());
		
		tf = new JTextField("Bucky is awesome and hot", 25);
		add(tf);
		
		pb = new JRadioButton("plain", true);
		bb = new JRadioButton("bold", false);
		ib = new JRadioButton("italic", false);
		bib = new JRadioButton("bold and italic", false);
		add(pb);
		add(bb);
		add(ib);
		add(bib);
		
		group = new ButtonGroup(); // we group the buttons, so when one is checked, the others know to uncheck themselves
		group.add(pb);
		group.add(bb);
		group.add(ib);
		group.add(bib);
		
		pf = new Font("Serif", Font.PLAIN, 14);
		bf = new Font("Serif", Font.BOLD, 14);
		itf = new Font("Serif", Font.ITALIC, 14);
		bif = new Font("Serif", Font.BOLD + Font.ITALIC, 14);
		
		tf.setFont(pf);
		
		pb.addItemListener(new HandlerClass(pf)); // wait for event to happen, pass in font object to constructor
		bb.addItemListener(new HandlerClass(bf));
		ib.addItemListener(new HandlerClass(itf));
		bib.addItemListener(new HandlerClass(bif));
	}
	
	private class HandlerClass implements ItemListener{
		private Font font;
		
		public HandlerClass(Font f){
			font = f;
		}

		@Override
		public void itemStateChanged(ItemEvent event) {

			tf.setFont(font);
			
		}
	}
	
}
