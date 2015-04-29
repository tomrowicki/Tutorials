package bucky.intermediate.messengerclient;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Client extends JFrame {

	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private String message = "";
	private String serverIp;
	private Socket connection;
	
	// constructor
	public Client(String host){
		
		super("Bucky's messenger client");
		serverIp = host;
		userText = new JTextField();
		userText.setEditable(false);
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand());
					userText.setText("");
				}
			}	
		);
		
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow), BorderLayout.CENTER);
		setSize(300, 150);
		setVisible(true);
	}
	
	// stating the client
	public void startRunning(){
		
		try{
			connectToServer();
			setupStreams();
			whileChatting();
		}
		catch(EOFException eofException){
			showMessage("\n Client terminated connection");
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
		finally{
			closeCrap();
		}
	}
	
	// connect to the server
	private void connectToServer() throws IOException{
		showMessage("Attempting connection... \n");
		connection = new Socket(InetAddress.getByName(serverIp), 6789);
		showMessage("Connected to: " + connection.getInetAddress().getHostName());
	}
	
	// set up streams to send and receive messages
	private void setupStreams() throws IOException{
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush();
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Dude, your streams are now good to go! \n");
	}
	
	// maintaining server connection
	private void whileChatting() throws IOException{
		
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException classNotFoundException){
				showMessage("\n I don't know that object type");
			}
		}
		while(!message.equals("SERVER - END"));
	}
	
	// close the streams and sockets
	private void closeCrap(){
		
		showMessage("\n Closing crap down...");
		ableToType(false);
		try{
			output.close();
			input.close();
			connection.close();
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	// send messages to the server
	private void sendMessage(String message){
		
		try{
			output.writeObject("CLIENT - " + message); // this is sent to the server but not visible on the screen
			output.flush();
			showMessage("\n ClIENT - " + message); // this makes the message visible
		}
		catch(IOException ioException){
			chatWindow.append("\n something messed up sending message, hoss!");
		}
	}
	
	// change/update chatWindow
	private void showMessage(final String m){
		
		SwingUtilities.invokeLater(
			new Runnable(){
				public void run(){
					chatWindow.append(m); // the latest message appears at the end of the conversation
				}
			}	
		);
	}
	
	// gives user permission to type crap into the text box
	private void ableToType(final boolean tof){
		SwingUtilities.invokeLater(
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}	
			);
	}
}
