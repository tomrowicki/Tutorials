import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.Random;


public class Platform {

	int dx;
	int x, y, width, height;
	Image plat;
	URL url;
	float frame = 0;
	
	public Platform(){
		
		dx = -1;
		x = 300;
		y = 300;
		width = 120;
		height = 40;
	}
	
	public Platform(int x, int y){
		this.x = x;
		this.y = y;
		width = 120;
		height = 40;
		dx = -1;
		plat = Pics.platform;
		
	}
	
	public void update(StartingPoint sp, Ball b){
		
		// used for alternate changing between 3 states, which allows for platform animation (3 tiles) 
		int tester = (int)(frame + .1);
		if (tester < 3){
			frame += .1;
		}
		else{
				frame = 0;
		}
		
		x += -(Pics.level); // platforms speed up over time
		checkForCollision(b);
		if (x < 0 - width){
			// once the platform leaves the left side screen, it reappears on the
			// right side at a randomised height
			Random r = new Random();
			y = sp.getHeight() - 40 - r.nextInt(400);
//			x = sp.getWidth() + r.nextInt(300); // randomness of 300 pixels
		}
			
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	private void checkForCollision(Ball b){
		
		int ballX = b.getX();
		int ballY = b.getY();
		int radius = b.getRadius();
		
		// checking if the ball hits the height of the upper edge of the platform
		if (ballY + radius > y && ballY+radius < y + height){
			if (ballX > x && ballX < x + width){
				double newDy = b.getGameDy();
				b.setY(y-radius); // making sure that the ball can't even partially phase through the platform???
				b.setDy(newDy);
				Pics.bounce.play();
			}
		}
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.BLUE);
		g.fillRect(x, y, width, height);
		
		//g.drawImage(plat, x, y, Pics.sp);
		g.drawImage(plat, x, y, x+width, y+height, 0, 40 *(int) frame, 120, 40 *(int) frame + 40, Pics.sp); // the second half of params refers to how to cut from the image file
	}	// one tile is 120x40
	
}
