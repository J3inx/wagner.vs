package GamesWithObjects;

public class triangle {
	private int Xpos, Ypos, Yspeed;
	private int Xspeed ;
	public triangle() {
		Xpos = (int)(Math.random()*10000+500);
		Xspeed = (int)(Math.random()*5+1)*-1;
		Ypos = 260;
	}
	public int getXpos() {
		Xpos += Xspeed;
		
		return Xpos;
	}
	public int getYpos() {
		return Ypos;
	}
	public void setXspeed() {
		
	}
	public void setYspeed() {
		
	}
	public void setXpos(int x) {
		Xpos = x;
	}
}
