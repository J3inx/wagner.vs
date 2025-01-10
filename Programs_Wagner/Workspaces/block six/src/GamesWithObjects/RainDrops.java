package GamesWithObjects;

public class RainDrops {
	
	private int size, xPos, yPos, ySpeed;
	public RainDrops() {
		
		size = (int)(Math.random()*20+1);//1-20
		xPos = (int)(Math.random()*601+1);//between 600-1 inclusive
		yPos = (int)(Math.random()*101+1)*-1;
		ySpeed = (int)(Math.random()*5+1);
		
		
	}
	public int getYpos() {
		yPos += ySpeed;
		return yPos;
	}
	public int getXpos() {
		return xPos;
	}
	public int getSize() {
		return size;
	}
	
	
}
