package GamesWithObjects;

public class bucketControl {
	private int xPos, yPos, xSpeed, ySpeed;
	public void Bucket() {
		xPos = 200;
		yPos = 700;
		xSpeed = 0;
	}
	public int getXpos() {
		xPos += xSpeed;
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
	  public int Xspeed() {
	        return xSpeed;
	    }
}
