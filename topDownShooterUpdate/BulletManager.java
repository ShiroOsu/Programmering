package topDownShooter;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class BulletManager {
	
	private Player player;
	private BufferedImage image;
	
	
	private ArrayList<Bullet> bullets = new ArrayList<>();
	
	public BulletManager(Player player){
		this.player = player;
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
	}
	
	public void render(Graphics g){
		for(int i = 0; i < bullets.size(); i++){
			g.drawImage(image, (int)bullets.get(i).getX() + 27, (int)bullets.get(i).getY() - 15, bullets.get(i).getWidth(), bullets.get(i).getHeight(), null);
		}
	}
	
	public int getBullets(){
		return bullets.size();
	}
	
	
	/*
	 * test
	 */
	public void addBullet(int x, int y){
		bullets.add(new Bullet(x, y));
	}
	
	public Rectangle coll(double x, double y){
		return new Rectangle((int)x, (int)y, 25, 25);
		
	}

	public void update(){
		if(player.isFiring()){
			bullets.add(new Bullet(player.getX(), player.getY()));
			player.setFiring(false);	
			
		}
		/*
		 * utanför skärmen
		 */
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).move();
			if(bullets.get(i).getY() < 0){
				bullets.remove(i);
			}	
		}
	}
}
