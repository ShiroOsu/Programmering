package topDownShooter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public abstract class Entity {
	
	
	// Fields
	
	protected double width, height, x, y;
	protected double speed;
	protected BufferedImage image;
	
	
	
	public Entity(BufferedImage image, double x, double y, double width, double height, double speed){
		this.image = image;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.speed = speed;
	}
	
	
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, (int)width, (int)height, null);
		
	}
	
	public void move(){
		y += speed;
	}
	
	public void update(){
		
	}
}
