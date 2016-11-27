package topDownShooter;

import java.awt.Graphics;
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
			g.drawImage(image, (int)bullets.get(i).getX(), (int)bullets.get(i).getY(), 40, 40, null);
		}
	}
	
	

	
	public void update(){
		if(player.isFiring()){
			bullets.add(new Bullet(player.getX(), player.getY()));
			player.setFiring(false);	
			
		}
		
		for(int i = 0; i < bullets.size(); i++){
			bullets.get(i).move();
			
		}
	}
}
