package topDownShooter;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.RenderingHints.Key;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;



public class Player extends Entity implements KeyListener {
	
	

	
	private boolean up, down, left, right, spawn;
	private static boolean isFiring;
	private long fireDelay;
	
	
	

	public Player(int x, int y, BufferedImage image, double width, double height, double speed) {
		super(image, x, y, width, height, speed);

		
	}

	public void update() {
		if(up == true){
			y -= speed;
			if(y < 0){
				y = 0;
			}
		}
		if(down == true){
			y += speed;
			if(y + 80 > 700){
				y = 620;
			}
		}
		if(left == true){
			x -= speed;
			if(x < 0){
				x = 0;
			}
		}
		if(right == true){
			x += speed;
			if(x + 80 > 600){
				x = 520;
			}
		}
		if(spawn == true){
			Game.level1.addEnemy();
		}
		

	}
	
	

	public void render(Graphics g) {
		g.drawImage(image, (int)x, (int)y, 80, 80, null);
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
	public void add(boolean b){
		spawn = b;
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
		if(k == KeyEvent.VK_Q){
			add(true);
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
		if(k == KeyEvent.VK_Q){
			add(false);
		}
	}
}
