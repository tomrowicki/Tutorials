import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;


public class Item {

	private int x, y, dx, radius;
	private StartingPoint sp;
	private boolean createNew = false;
	
	public Item(int x){
		
		this.x = x;
		Random r = new Random();
		y = r.nextInt(400) + radius;
		radius = 10;
		dx = -2;
		
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getDx() {
		return dx;
	}

	public void setDx(int dx) {
		this.dx = dx;
	}

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public StartingPoint getSp() {
		return sp;
	}

	public void setSp(StartingPoint sp) {
		this.sp = sp;
	}

	public boolean isCreateNew() {
		return createNew;
	}

	public void setCreateNew(boolean createNew) {
		this.createNew = createNew;
	}

	public void update(StartingPoint sp, Ball b){
		
		x += dx;
		this.sp = sp; // gets the StartingPoint parameters and updates this object's field with 'em
		checkForCollision(b);
		if (x < 0 - radius){
			createNew = true;
		}
			
	}
	
	private void checkForCollision(Ball ball){
		
		int ballX = ball.getX();
		int ballY = ball.getY();
		int ballR = ball.getRadius();
		
		// making use of Pythagoras' Theorem to detect collisions
		int a = x - ballX;
		int b = y - ballY;
		int collide = radius + ballR; // collision distance between the centers of round objects
		double c = Math.sqrt((double) (a*a) + (double) (b*b)); // distance between object centers
		
		if (c<collide){
			performAction(ball); // TODO
			createNew = true;
		}
	}
	
	public void performAction(Ball b){
		
		
	}
	
	public void paint(Graphics g){
		
		//g.setColor(Color.GREEN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // circle centered around 0, 0 position

	}
}
