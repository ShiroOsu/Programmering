package topDownShooter;



public class Bullet {
		private double x, y;
		private double speed = 7.0;
		private int damage;
		
		
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
		
		public int getDamge(){
			return damage;
		}
		
		public void setDamage(int d){
			damage = d;
		}
		
		public int getWidth(){
			return 25;
		}
		
		public int getHeight(){
			return 25;
		}
	
		public double getSpeed(){
			return speed;
		}
		
		public void move(){
			y -= speed;
			
		}
}



