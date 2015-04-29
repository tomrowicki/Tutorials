import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class JLista extends JFrame {
	
	private JList list;
	private static String[] colornames = {"black", "blue", "red,", "white"};
	private static Color[] colors = {Color.BLACK, Color.BLUE, Color.RED, Color.WHITE};
	
	public JLista(){
		super("the title");
		setLayout(new FlowLayout());
		
		list = new JList(colornames);
		list.setVisibleRowCount(4); // how many options u can see by default
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // user can select only 1 thing
		add(new JScrollPane(list));
		
		list.addListSelectionListener( // adding event handler through an anonymous interclass
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event){
						getContentPane().setBackground(colors[list.getSelectedIndex()]); // automatically matches colors with colornames based on the order
					}
				}
				
		);
	
	}
	

}
