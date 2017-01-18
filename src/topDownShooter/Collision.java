package topDownShooter;

import java.awt.Rectangle;

public class Collision {
	
	public Collision(){
		
	}
	
	public boolean hit(Rectangle a, Rectangle b){
		if(a.intersects(b) || b.intersects(a)){
			return true;
		}
		return false;
	}
}
