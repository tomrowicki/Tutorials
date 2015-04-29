import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class MSelectionList extends JFrame {
	
	private JList leftList;
	private JList rightList;
	private JButton moveButton;
	private static String[] foods = {"bacon", "wings", "ham", "beef", "morebacon"};
	
	public MSelectionList(){
		super("title");
		setLayout(new FlowLayout());
		
		leftList = new JList(foods);
		leftList.setVisibleRowCount(3);
		leftList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION); // selecting multiple items
		add(new JScrollPane(leftList)); // puts a scroll bar on the list
		
		moveButton = new JButton("Move -->");
		moveButton.addActionListener(
					new ActionListener(){
						@SuppressWarnings("deprecation")
						public void actionPerformed(ActionEvent event){
							rightList.setListData(leftList.getSelectedValues());
						}
					}
				);
		add(moveButton);
		
		rightList = new JList();
		rightList.setVisibleRowCount(3);
		rightList.setFixedCellWidth(100);
		rightList.setFixedCellHeight(15);
		rightList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		add(new JScrollPane(rightList));
		
	}

}
