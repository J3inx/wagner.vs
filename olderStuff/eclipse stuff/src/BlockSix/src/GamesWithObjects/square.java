package GamesWithObjects;

public class square {
	int Xpos, Ypos=250, Xspeed, Yspeed;
	 int ground = 250;
	int gravity = -22;
	private int gravitytwo;
	 boolean jump = false;
	//public square(){
	
	//}
		public int getXpos() {
		return Xpos;
	}
	public int getYpos() {
		
		if(Ypos>=250) {
			jump = false;
			gravity=-22;
			Yspeed=0;
			Ypos=250;
		} 
		
		return Ypos;
	}
	public void moveyPos(){
		if(jump == true) {
			Yspeed=gravity;
			gravity+=1;
		}
		Ypos=Ypos+Yspeed;
			
	}
	public void jump(boolean x) {
		jump = x;
		}
		
	}

