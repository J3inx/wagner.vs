package agario;

public class Player {
	private int xPos = 50, yPos = 300, width = 30, height = 30, velX = 0, velY = 0;
	public Player() {
		xPos = 222;
		yPos = 222;
		width = 30;
		height = 30;
	}
	public Player(int xPos, int yPos, int width, int height) {
		this.xPos = xPos;
		this.yPos = yPos;
		this.width = width;
		this.height = height;
	}
	
	public int getxPos() {
		return xPos;
	}
	

	
	public void setxPos(int x) {
		xPos = x;
	}
	
	public int getxVel() {
		return velX;
	}
	
	public void setxVel(int x) {
		velX = x;
	}
	
	

	public int getyPos() {
		return yPos;
	}
	
	public void setyPos(int y) {
		yPos = y;
	}

	public int getyVel() {
		return velY;
	}
	
	public void setyVel(int y) {
		velY = y;
	}
	


	public int getWidth() {
		return width;
	}


	


	public int getHeight() {
		return height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	

}
