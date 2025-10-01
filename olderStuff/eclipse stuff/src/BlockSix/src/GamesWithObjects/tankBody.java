package GamesWithObjects;

public class tankBody {
	//global variables
	private int xPos, yPos, xSpeed, ySpeed;
	//constructor
	public tankBody() {
		xPos=100;
		yPos=485;
		xSpeed = 0;
		ySpeed = 0;
		
	}
	public int getXPos() {
		return xPos;
	}
	public int getYPos() {
		return yPos;
	}
	public void setXSpeed(int speed) {
		xPos += speed;
	}
	public void setYSpeed(int speed) {
		yPos += speed;
	}
}
