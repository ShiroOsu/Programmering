package topDownShooter;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Enemy extends Mob {
	private double health, damage;
	

	public Enemy(BufferedImage image, double x, double y, double width, double height, double speed) {
		super(image, x, y, width, height, speed);
		// TODO Auto-generated constructor stub
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setHealth(double h){
		health = h;
	}
	
	public double getHealth(){
		return health;
	}
	
	public void getDamaged(int d){
		health = -d;
	}
	
	public void setDamage(double d){
		damage = d;
	}
	
	public double getDamage(){
		return damage;
	}
	
	public void setSpeed(double s){
		speed = s;
	}
	
	public double getSpeed(){
		return speed;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	public Rectangle coll(int width, int height){
		return new Rectangle((int)x, (int)y, width, height);
	}
}


