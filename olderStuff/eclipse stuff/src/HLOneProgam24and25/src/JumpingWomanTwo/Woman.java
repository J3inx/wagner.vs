package JumpingWomanTwo;

public class Woman {
	//global class variables
	//private and public are encapsulation
	private int xPos, yPos, xVelocity, yVelocity;
	private int red, green, blue;
	//constructor method
	public Woman() {
		xPos = (int)(Math.random()*400+100);
		//places them anywhere from 100 to 400
		yPos= 100;
		xVelocity = 0;
		yVelocity = 0;
		red = (int)(Math.random()*256);
		//256 because it goes to 255.999 then truncates to 255
		green = (int)(Math.random()*256);
		blue = (int)(Math.random()*256);
		
	}
	public int getxPos() {
		return xPos;
	}
	public int getyPos() {
		return yPos;
	}
	public int getxVelocity() {
		return xVelocity;
	}
	public int getyVelocity() {
		return yVelocity;
	}
	public int getRed() {
		return red;
	}
	public int getGreen() {
		return green;
	}
	public int getBlue() {
		return blue;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public void setxVelocity(int xVelocity) {
		this.xVelocity = xVelocity;
	}
	public void setyVelocity(int yVelocity) {
		this.yVelocity = yVelocity;
	}
	public void setRed(int red) {
		this.red = red;
	}
	public void setGreen(int green) {
		this.green = green;
	}
	public void setBlue(int blue) {
		this.blue = blue;
	}
	
	//getter method ^
	//setter methods v
	
	
}
