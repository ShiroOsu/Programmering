package topDownShooter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;



public class Player extends Mob implements KeyListener {
	
	

	
	private boolean up, down, left, right;
	private static boolean isFiring;
	private long fireDelay;
	private int damage;
	
	
	

	public Player(int x, int y, BufferedImage image, double width, double height, double speed) {
		super(image, x, y, width, height, speed);

		
	}

	public void update() {
		if(up){
			y -= speed;
			if(y < 0){
				y = 0;
			}
		}
		if(down){
			y += speed;
			if(y + 80 > 700){
				y = 620;
			}
		}
		if(left){
			x -= speed;
			if(x < 0){
				x = 0;
			}
		}
		if(right){
			x += speed;
			if(x + 80 > 600){
				x = 520;
			}
		}
	}
	
	

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	
	
	
	
	public void setUp(boolean b){
		up = b;
	}
	
	public void setDown(boolean b){
		down = b;
	}
	
	public void setLeft(boolean b){
		left = b;
	}
	
	public void setRight(boolean b){
		 right = b;
	}
	
	public void setFiring(boolean b){
		isFiring = b;
	}
	
	public boolean isFiring(){
		return isFiring;
	}
	
	public long getFireDelay(){
		return fireDelay;
	}
	
	public long setFireDelay(long l){
		return fireDelay = l;
	}
	
	
	
	public double getY(){
		return y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getWidth(){
		return width;
	}
	
	public double getHeight(){
		return height;
	}
	
	public int getDamage(){
		return damage;
	}
	
	public void setDamage(int d){
		damage = d;
	}
	
	public Rectangle coll(double x, double y){
		return new Rectangle((int)x, (int)y, 80, 80);
	}
	
	
	

	
	public void keyTyped(KeyEvent e) {

	}

	public void keyPressed(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_W){
			setUp(true);
		}
		if(k == KeyEvent.VK_S){
			setDown(true);
		}
		if(k == KeyEvent.VK_A){
			setLeft(true);
		}
		if(k == KeyEvent.VK_D){
			setRight(true);
		}
		if(k == KeyEvent.VK_F){
			setFiring(true);
		}
	}

	public void keyReleased(KeyEvent e) {
		int k = e.getKeyCode();
		if(k == KeyEvent.VK_W){
			setUp(false);
		}
		if(k == KeyEvent.VK_S){
			setDown(false);
		}
		if(k == KeyEvent.VK_A){
			setLeft(false);
		}
		if(k == KeyEvent.VK_D){
			setRight(false);
		}
		if(k == KeyEvent.VK_F){
			setFiring(false);
		}
	}
}
