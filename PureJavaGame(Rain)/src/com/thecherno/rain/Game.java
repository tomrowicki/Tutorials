package com.thecherno.rain;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.JFrame;

import com.thecherno.rain.graphics.Screen;

public class Game extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	
	public static int width = 300;
	public static int height = width / 16 * 9; // setting a 16:9 ratio, equals 168
	public static int scale = 3; // used to scale up the resolution and still make everything appear retro-style
	public static String title = "Rain";
	
	private Thread thread;
	private JFrame frame; // window
	private boolean running = false; // determines the running of the game loop
	
	private Screen screen;
	
	private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	private int[] pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData(); // manipulable data from the raster representation of the image
	
	public Game(){
		
		Dimension size = new Dimension(width * scale, height * scale);
		setPreferredSize(size); // method inherited from the Canvas class
		
		screen = new Screen(width, height);
		frame = new JFrame();
	}
	
	public synchronized void start(){ // synchronized assures memory consistency and that there's no interference between threads
									// all reads and writes to the object from various threads are done in a valid, synchronized way
		running = true;
		thread = new Thread(this, "Display"); // each new thread incorporates the game object entitled "Display"
		thread.start(); // it automatically invokes the run method
	}
	
	public synchronized void stop(){
		
		try{
		thread.join(); // waiting for a thread to die
		} catch (InterruptedException e){
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime(); // more precise than the currentTime method
		long timer = System.currentTimeMillis();
		final double ns = 1000000000.0 / 60.0;
		double delta = 0;
		int frames = 0;
		int updates = 0;
		while (running){
			long now = System.nanoTime();
			delta += (now = lastTime) / ns; // used for FPS counter
			lastTime = now;
			while (delta >= 1){
				update(); // sometimes called tick(), game logic goes here and it's running at a limited fps ratio
				updates ++;
				delta --; // resetting delta (it's back to 0)
			}
			render(); // no limit to the speed of calculations here
			frames ++;
			
			if (System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println(updates + " ups, " + frames + " fps");
				frame.setTitle(title + "   |   " + updates + " ups, " + frames + " fps");
				updates = 0;
				frames = 0;
			}
		}
		stop();
	}
	
	public void update(){
	
	}
	
	public void render(){
		
		// creating the buffer strategy
		BufferStrategy bs = getBufferStrategy();
		if (bs == null){
			createBufferStrategy(3); // triple buffering - if a computer manages to do that, it can store an additional frame in the buffer (2 instead of 1)
			return;
		}
		
		screen.clear();
		screen.render();
		
		for (int i = 0; i < pixels.length; i++){
			
			pixels[i] = screen.pixels[i]; // updating the current array of pixels with the manipulated values from the Screen object
		}
		
		Graphics g = bs.getDrawGraphics(); // linking modifiable graphics and the buffer
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
		g.dispose(); // disposes of the current graphics - housekeeping
		
		bs.show(); // keeps buffering, displaying, and disposing cycle going
	} 
	
	public static void main(String[] args){
		
		Game game = new Game();
		game.frame.setResizable(false);
		game.frame.setTitle("Rain");
		game.frame.add(game);
		game.frame.pack(); // sets the size for the component(game)
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setLocationRelativeTo(null); // centering window inside the screen
		game.frame.setVisible(true); // makes the window visible - kinda important :)
		
		game.start();
	}
}