package GamesWithObjects;

public class Blocker {
	private int xPos, yPos, xSpeed, ySpeed;
	public Blocker() {
		xPos = 200;
		yPos = 700;
		xSpeed = 1;
	}
	public int getXpos() {
		if(xPos >= 800) {
			xSpeed = -1;
		}
		if(xPos<=0) {
			xSpeed= 1;
			xPos = xPos + xSpeed;
		}
		return xPos;
	}
	public int getYpos() {
		return yPos;
	}
}
