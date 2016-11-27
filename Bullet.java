package topDownShooter;

public class Bullet {
		private double x, y;
		private double speed = 6.9;
		
		
		public Bullet(double x, double y){
			this.x = x;
			this.y = y;
		}
		
		public double getX(){
			return x;
		}
		
		public double getY(){
			return y;
		}
		
		public void setSpeed(int s){
			speed = s;
		}
		
		
		
		public double getSpeed(){
			return speed;
		}
		
		public void move(){
			y -= speed;
			
		}
		
		

}
