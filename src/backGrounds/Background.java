package backGrounds;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import topDownShooter.Game;

public class Background {
	private double x, y, dx, dy ,moveScale;
	
	private BufferedImage image;
	
	public Background(String s, double ms){
		
		try{
			
			image = ImageIO.read(getClass().getResourceAsStream(s));
			
			moveScale = ms;
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	
	public void setPosition(double x, double y){
		this.x = (x * moveScale) % Game.WIDTH;
		this.y = (y * moveScale) % Game.HEIGHT;
		
	}
	
	public void setVector(double dx, double dy){
		this.dx = dx;
		this.dy = dy;
		
	}
	
	public void update(){
		x += dx;
		y += dy;
	}
	/**
	 * scrollandes bakgrund
	 * @param g
	 */
	public void render(Graphics g){
		g.drawImage(image, (int)x, (int)y, null);
		if(y < 0){
			g.drawImage(image, (int)x, (int)y + Game.HEIGHT, null);
		}
		if(y > 0){
			g.drawImage(image, (int)x, (int)y - Game.HEIGHT, null);
		}
	}

}
