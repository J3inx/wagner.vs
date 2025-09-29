package agario;

public class Food {
	int r;
	int g;
	int b;
	int x;
	int y;
	int height;
	int width;
	boolean active = true;
	public Food() {
	x = (int)(Math.random()*1000)+1;
	y = (int)(Math.random()*1000)+1;
	r = (int)(Math.random()*254)+1;
	g = (int)(Math.random()*254)+1;
	b = (int)(Math.random()*254)+1;
	height = 10;
	width = 10;
	//height = (int)(Math.random()*254)+1;
	//width = (int)(Math.random()*254)+1;
	}
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	public int getR() {
		return r;
	}
	public int getG() {
		return g;
	}
	public int getB() {
		return b;
	}
	public int getX() {
		return x;
	}
	public int getY() {
		return y;
	}
	public void setR(int r) {
		this.r = r;
	}
	public void setG(int g) {
		this.g = g;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public boolean getActive() {
		return active;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public Food(int x, int y) {
		
	}
	public Food(int x, int y, int width, int height) {
		
	}
	public Food(int x, int y, int width, int height, int r, int g, int b) {
		
	}
}
