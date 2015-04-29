package Java.Intermediate;

import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Server extends JFrame {
	
	private JTextField userText;
	private JTextArea chatWindow;
	private ObjectOutputStream output;
	private ObjectInputStream input;
	private ServerSocket server;
	private Socket connection;
	
	//constructor
	public Server(){
		
		super("Bucky's Instant Messenger");
		userText = new JTextField();
		userText.setEditable(false); // you can't type before the connection is established
		userText.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent event){
					sendMessage(event.getActionCommand()); // what happens when u hit enter
					userText.setText(""); // make the message area blank after sending ur message
				}
			}
		);
		add(userText, BorderLayout.NORTH);
		chatWindow = new JTextArea();
		add(new JScrollPane(chatWindow));
		setSize(300, 150);
		setVisible(true);
		
	}
	
	// set up and run the server
	public void startRunning(){
		try{
			server = new ServerSocket(6789, 100); // first param stands for port number, second is backlog (number of queued incoming connections)
			while(true){
				try{
					waitForConnection();
					setupStreams();
					whileChatting();
				}
				catch(EOFException eofException){ // end of connection exception
					showMessage("\n Server ended the connection!");
				}
				finally{
					closeCrap();
				}
			}
		}
		catch(IOException ioException){
			ioException.printStackTrace();
		}
	}
	
	// wait for connection, then display connection information
	private void waitForConnection() throws IOException{
		
		showMessage("Waiting for someone to connect... \n");
		connection = server.accept(); // server accepts the connection to the socket
		// socket is created only one time, once the connection is established
		showMessage("Now connected to" + connection.getInetAddress().getHostAddress());
	}
	
	// get stream to send and receive data
	private void setupStreams() throws IOException{
		
		output = new ObjectOutputStream(connection.getOutputStream());
		output.flush(); // flushing out the redundant data
		input = new ObjectInputStream(connection.getInputStream());
		showMessage("\n Streams are now set up!");
	}
	
	// during the chat conversation
	private void whileChatting() throws IOException{
		String message = "You are now connected!";
		sendMessage(message);
		ableToType(true);
		do{
			try{
				message = (String) input.readObject();
				showMessage("\n" + message);
			}
			catch(ClassNotFoundException classNotFoundException){
				showMessage("\n idk wtf that user sent");
			}
		}while(!message.equals("CLIENT - END")); // program stops once a user sends a message "END"
	}
	
	// close streams and sockets after you are done chatting
	private void closeCrap(){
		
		showMessage("\n Closing connections...\n");
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
	
	// send a message to a client, as opposed to showMessage which displays messages in a sort of a histor log
	private void sendMessage(String message){
		
		try{
			output.writeObject("SERVER - " + message);
			output.flush();
			showMessage("\n Server - " + message);
		}
		catch(IOException ioException){
			chatWindow.append("\n ERROR: DUDE, I CAN'T SEND THAT MESSAGE!");
		}
	}
	
	// updates chat window
	private void showMessage(final String text){
		
		SwingUtilities.invokeLater( // setting up a thread that will update parts of the gui
			new Runnable(){
				public void run(){
					chatWindow.append(text); // updating the chat window
				}
			}					
		);
	}
	
	// lets the users type stuff into their box
	private void ableToType(final boolean tof){
		
		SwingUtilities.invokeLater( // setting up a thread that will update parts of the gui
				new Runnable(){
					public void run(){
						userText.setEditable(tof);
					}
				}					
		);
	}

}
