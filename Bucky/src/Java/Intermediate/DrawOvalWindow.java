package Java.Intermediate;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class DrawOvalWindow extends JFrame {
	
	private JSlider slider;
	private DrawOval myPanel;
	
	public DrawOvalWindow(){
		
		super("The title");
		myPanel = new DrawOval();
		myPanel.setBackground(Color.ORANGE);
		
		slider = new JSlider(SwingConstants.HORIZONTAL, 0, 200, 10); // min 0 pixels wide max 200
		slider.setMajorTickSpacing(10); // tick every 10 pixels
		slider.setPaintTicks(true);
		
		slider.addChangeListener(
				new ChangeListener(){
					public void stateChanged(ChangeEvent e) {
						myPanel.setD(slider.getValue());
						
					}
				}
		);
		
		add(slider, BorderLayout.SOUTH);
		add(myPanel, BorderLayout.CENTER);		
		
	}

}
