import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;


public class AdapterClasses extends JFrame {

	private String details;
	private JLabel statusbar;
	
	public AdapterClasses(){
		super("title");
		
		statusbar = new JLabel("this is default");
		add(statusbar, BorderLayout.SOUTH);
		addMouseListener(new Mouseclass());
		
	}
	
	private class Mouseclass extends MouseAdapter { // adapter classes allow you to only override those methods that you need overriden
		public void mouseClicked(MouseEvent event){
			details = String.format("You clicked %d ", event.getClickCount());
			
			if(event.isMetaDown()){ // used for 2nd mouse button emulation on macs
				details += "with right mouse button";
			}
			else if(event.isAltDown()){
				details += "or center mouse button";				
				}
			else{
				details += "with left mose button";
			}
			
			statusbar.setText(details);
			 
		}
	}
}

