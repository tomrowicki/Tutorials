import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Layout extends JFrame {

	private JButton lb;
	private JButton cb;	
	private JButton rb;
	private FlowLayout layout;
	private Container container;
	
	public Layout(){
		super("the title");
		layout = new FlowLayout();
		container = getContentPane();
		setLayout(layout);
		
		lb = new JButton("left");
		add(lb);
		lb.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.LEFT);
						layout.layoutContainer(container);
						
					}
					
				}
				
		);
		
		cb = new JButton("center");
		add(cb);
		cb.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.CENTER);
						layout.layoutContainer(container);
						
					}
					
				}
				
		);
		
		rb = new JButton("right");
		add(rb);
		rb.addActionListener(
				new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent event) {
						layout.setAlignment(FlowLayout.RIGHT);
						layout.layoutContainer(container);
						
					}
					
				}
				
		);
	}
}
