package Java.Intermediate;

import java.net.*;
import java.util.*;
import java.awt.*;
import java.applet.*;

import javax.swing.*;
import javax.swing.event.*;

public class Networking extends JApplet {
	
	private HashMap<String, URL> websiteInfo;
	private ArrayList<String> titles;
	private JList mainList;
	
	public void init()
	{
		websiteInfo = new HashMap<String, URL>();
		titles = new ArrayList<String>();
		
		grabHTMLInfo();
		add(new JLabel("What websited would u like to visit?"), BorderLayout.NORTH);
		mainList = new JList(titles.toArray());
		
		mainList.addListSelectionListener(
				new ListSelectionListener(){
					public void valueChanged(ListSelectionEvent event)
					{
						Object object = mainList.getSelectedValue(); // grabbing the title
						URL newDocument = websiteInfo.get(object);  // finding the url based on the title
						AppletContext browser = getAppletContext(); // getting the info about the user's browser
						browser.showDocument(newDocument); // use browser to go to the new url
						
					}
				}
		);
		add(new JScrollPane(mainList), BorderLayout.CENTER);
	}

	private void grabHTMLInfo(){
		
		String title;
		String address;
		URL url;
		int counter = 0;
		title = getParameter("title" + counter); // looking for the title in the html file
		
		while(title != null)
		{
			address = getParameter("address" + counter); // needs to be converted to URL, cuz Java only knows how to open URLs, not strings
			try
			{
				url = new URL(address);
				websiteInfo.put(title, url);
				titles.add(title);
			}
			catch(MalformedURLException urlException)
			{
				urlException.printStackTrace();
			}
			++counter;
			title = getParameter("title" + counter);
			
		}
	}
	
}
