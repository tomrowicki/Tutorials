import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;


public class Ball {

	private int x = 400;
	private int y = 25;
	private double dx = 0; // change in x (delta x)
	private double dy = 0;
	private int radius = 20;
	private double gravity = 15;
	private double energyloss = 1;
	private double xFriction = .9;
	private double dt = .2; // change in time
	private double gameDy = -75;
	private int agility = 3;
	private int maxSpeed = 20;
	private boolean gameover = false;
	
	public Ball() {
	
	}
	
	public Ball(int i, int j){
		
		x = i;
		y = j;
	}
	
	public int getX() {
		return x;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public int getY() {
		return y;
	}
	
	public void setY(int y) {
		this.y = y;
	}
	
	public double getDx() {
		return dx;
	}
	
	public void setDx(double dx) {
		this.dx = dx;
	}
	
	public double getDy() {
		return dy;
	}
	
	public void setDy(double dy) {
		this.dy = dy;
	}
	
	public double getGravity() {
		return gravity;
	}
	
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	
	public int getRadius() {
		return radius;
	}
	
	public double getGameDy() {
		return gameDy;
	}
	
	public void setGameDy(double gameDy) {
		this.gameDy = gameDy;
	}
	
	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(int maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public void moveRight(){
		
		// capping maximum speed to the right
		if (dx + agility < maxSpeed){
			dx += agility;
		}
	}
	
	public void moveLeft(){
		if (dx - agility > -maxSpeed){
			dx -= agility;
		}
	}
	
	public void update(StartingPoint sp){
		
		// simple animation that does not allow the ball to leave the screen
		if(x + dx > sp.getWidth() - radius - 1){
			x = sp.getWidth() - radius - 1;
			dx = -dx;
		} 
		else if(x + dx < 0 + radius){
			x = 0 + radius;
			dx = -dx;
		}
		else{
			x += dx;
		}
	
		if(y == sp.getHeight() - radius - 1){
			dx *= xFriction;
			if (Math.abs(dx) < .8){
				dx = 0;
			}
		}
		
		// what happens when the ball hits the ground
		if(y - 200 > sp.getHeight() - radius - 1){
			gameover = true;
			
			// portion for bouncing off the ground
//			y = sp.getHeight() - radius - 1;
//			dy *= energyloss;
//			dy = gameDy;
			
		}
		else{
			// velocity formula
			dy += gravity * dt;
			// position formula
			y += dy*dt + .5*gravity*dt*dt;
		}
	}
	
	public void paint(Graphics g){
		
		g.setColor(Color.GREEN);
		g.fillOval(x - radius, y - radius, radius * 2, radius * 2); // circle centered around 0, 0 position
	}

	public boolean getGameOver() {

		
		return gameover;
	}
}
