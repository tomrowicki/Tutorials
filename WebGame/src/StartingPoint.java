import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.net.URL;
import java.util.Random;

public class StartingPoint extends Applet implements Runnable, KeyListener,
		MouseMotionListener, MouseListener {

	private Image i;
	private Graphics doubleG; // some silly gangsta reference
	Ball b;
	Platform p[] = new Platform[7];
	Item item[] = new Item[3];
	private int score;
	double cityX = 0; // used for background image
	double cityDx = 3;
	URL url;
	Image background;
	int levelcheck = 0;
	boolean gameOver = false;
	boolean mouseIn = false;

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	// this is called only once, when starting an applet; the applet skips to
	// start(), if this is empty
	@Override
	public void init() {
		setSize(800, 600);
		addKeyListener(this);
		addMouseListener(this);
		addMouseMotionListener(this);
		setFocusable(true);
		requestFocusInWindow();
		try {
			url = getDocumentBase();
		} catch (Exception e) {
			System.out.println(e);
		}
		background = getImage(url, "images/plane.jpg");
		new Pics(this); // passing sp configuration
		Pics.wind.play(); // plays only once
		Pics.music.loop(); // looped play
	}

	@Override
	public void start() {

		b = new Ball();
		score = 0;
		for (int i = 0; i < p.length; i++) {
			Random r = new Random();
			// randomised creation of 7 platforms
			p[i] = new Platform(i * 120, 300);
		}
		for (int i = 0; i < item.length; i++) {
			Random r = new Random();
			switch (r.nextInt(5)) {
			case 0:
				item[i] = new GravUp(getWidth() + 200 * i);
				break;
			case 1:
				item[i] = new GravDown(getWidth() + 200 * i);
				break;
			case 2:
				item[i] = new AgilUp(getWidth() + 200 * i);
				break;
			case 3:
				item[i] = new AgilDown(getWidth() + 200 * i);
				break;
			case 4:
				item[i] = new ScorePlus(getWidth() + 2000 * i, this); // this
																		// refers
																		// to
																		// the
																		// applet
																		// info
				break;
			}
		}
		// parameters obtained via the run method
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
	}

	// used for getting rid of some data
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	@Override
	public void update(Graphics g) {
		// creating a copy of the image and showing it instead of blank space
		// during refresh, aka double buffering
		if (i == null) {
			i = createImage(this.getSize().width, this.getSize().height);
			doubleG = i.getGraphics();
		}

		// background of the oval needs to be copied
		doubleG.setColor(getBackground());
		doubleG.fillRect(0, 0, this.getSize().width, this.getSize().height);

		// colour of the oval needs to be copied and set as well
		doubleG.setColor(getForeground());
		paint(doubleG);

		g.drawImage(i, 0, 0, this);
	}

	@Override
	public void paint(Graphics g) {

		g.setColor(new Color(15, 77, 147));
		g.fillRect(0, 0, getWidth(), getHeight());
		g.drawImage(background, (int) cityX, 0, this);
		g.drawImage(background, (int) cityX + getWidth(), 0, this);

		for (int i = 0; i < p.length; i++) {
			p[i].paint(g);
		}
		for (int i = 0; i < item.length; i++) {
			item[i].paint(g);
		}
		b.paint(g);
		String s = Integer.toString(score);
		Font font = new Font("Serif", Font.BOLD, 32);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(s, getWidth() - 150 + 2, 50 + 2);
		g.setColor(new Color(198, 226, 255)); // shadow behind the text
		g.drawString(s, getWidth() - 150, 50);
		if (gameOver) {
			g.setColor(Color.WHITE);
			g.drawString("GAME OVER", 300, 300);
			g.drawRect(280, 320, 180, 40); // used for mouse check on game over
											// splash screen
			if (mouseIn) {
				g.setColor(Color.RED);
				g.drawString("Play again?", 280, 340);
			} else {
				g.setColor(Color.WHITE);
				g.drawString("Play again?", 280, 340);
			}
		}
	}

	// inherited from the Runnable (threads) class
	@Override
	public void run() {

		// thread information
		while (true) {

			// making sure the platforms don't spawn on one another
			for (int i=0; i<p.length; i++){
				int testx = p[i].getX();
				if (testx < 0 - p[i].getWidth()){
					Random r = new Random();
					int fakei = i; // used for dealing with the 0 index
					if (i == 0){
						fakei = p.length;
					}
					p[i].setX(p[fakei-1].getX() + p[i].getWidth() + Pics.level * r.nextInt(25));
				}
			}
			
			gameOver = b.getGameOver();

			if (levelcheck > 100) {
				Pics.level++;
				levelcheck = 0;
			}
			levelcheck++;

			if (cityX > getWidth() * -1) {
				cityX -= cityDx;
			} else {
				cityX = 0;
			}
			if (!gameOver) {
				score++;
			}

			Random r = new Random();

			for (int i = 0; i < item.length; i++) {
				if (item[i].isCreateNew()) {
					item[i] = null;
					// setting up powerups
					switch (r.nextInt(5)) {
					case 0:
						item[i] = new GravUp(getWidth() + 10 * r.nextInt(500));
						break;
					case 1:
						item[i] = new GravDown(getWidth() + 10 * r.nextInt(500));
						break;
					case 2:
						item[i] = new AgilUp(getWidth() + 10 * r.nextInt(500));
						break;
					case 3:
						item[i] = new AgilDown(getWidth() + 10 * r.nextInt(500));
						break;
					case 4:
						item[i] = new ScorePlus(getWidth() + 10
								* r.nextInt(500), this); // this refers to the
															// applet info
						break;
					}
					item[i].setCreateNew(false);
				}
			}

			b.update(this);
			for (int i = 0; i < p.length; i++) {
				p[i].update(this, b);
			}

			for (int i = 0; i < item.length; i++) {
				item[i].update(this, b);
			}
			repaint();
			// setting up the framerate for the game; 17 ms relates to rougly 60
			// fps (1000/60)
			try {
				Thread.sleep(17);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) { // each keyboard key has an assigned int value
		// case 37: // 37 relates to the left cursor key
		case KeyEvent.VK_LEFT: // also relates to the left cursor key
			b.moveLeft();
			break;
		case KeyEvent.VK_RIGHT: // also relates to the left cursor key
			b.moveRight();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if (gameOver) {
			if (e.getX() > 280 && e.getX() < 460) { // 280 + 180 = 460

				if (e.getY() > 320 && e.getY() < 360) {
					mouseIn = true;
				}
			}
			if (e.getX() < 280 || e.getX() > 460) {
				mouseIn = false;
			}
			if (e.getY() < 320 || e.getY() > 360) {
				mouseIn = false;
			}
		}

	}

	@Override
	public void mouseClicked(MouseEvent e) {

		if (mouseIn) {
			// clicking in the 'try again' box initialises a new game
			b = null;
			b = new Ball();
			score = 0;
			Pics.level = 1;

			for (int i = 0; i < p.length; i++) {
				Random r = new Random();
				// randomised creation of 7 platforms
				p[i] = new Platform(i * 120, 300);
			}
			for (int i = 0; i < item.length; i++) {
				Random r = new Random();
				switch (r.nextInt(5)) {
				case 0:
					item[i] = new GravUp(getWidth() + 200 * i);
					break;
				case 1:
					item[i] = new GravDown(getWidth() + 200 * i);
					break;
				case 2:
					item[i] = new AgilUp(getWidth() + 200 * i);
					break;
				case 3:
					item[i] = new AgilDown(getWidth() + 200 * i);
					break;
				case 4:
					item[i] = new ScorePlus(getWidth() + 2000 * i, this);
					break;
				}
			}

			mouseIn = false;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
