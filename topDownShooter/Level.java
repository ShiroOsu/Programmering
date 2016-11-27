package topDownShooter;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Level{
	private ArrayList<Enemy> enemies;
	private Enemy e;
	private BulletManager bulletManager;
	private BufferedImage image;
	private int random = 8;
	
	

	
	
	public Level(BulletManager bulletManager){
		this.bulletManager = bulletManager;
		enemies = new ArrayList<Enemy>();	
	}
	
	public void setImage(BufferedImage image){
		this.image = image;
		addEnemy();
		
	}
	
	private int rand(){
		return (int)(Math.random() * random * 70);

	}
	
	public int getMobCount(){
		return enemies.size();
	}
	
	public void addEnemy(){
		enemies.add(e = new Enemy(image, rand(), 0, 40, 40, 0.1));
		
	}
	/**
	 * om enemies är utanför skärmen lol ? ??? ? collision ??? 
	 */
	public void removeEnemy(){
		for(int i = 0; i < enemies.size(); i++){
			if(enemies.get(i).getY() - enemies.get(i).getHeight() > Game.HEIGHT){
				enemies.remove(i);
			}
		}
	}
	
	public void render(Graphics g){
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).render(g);
		}
		bulletManager.render(g);
	}
	
	public void update(){
		for(int i = 0; i < enemies.size(); i++){
			enemies.get(i).move();	
		}
		removeEnemy();
	}
}
