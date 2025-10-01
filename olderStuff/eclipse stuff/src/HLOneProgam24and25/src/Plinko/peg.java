package Plinko;

public class peg {
	private int yPos;
	private int xPos;
	private static int count = 1;
	public peg(int num, int numTwo, boolean debug)
	{
		setxPos(num);
		setyPos(numTwo);
		count++;
		if(debug) {
			debugPeg(count);
				
			}
	}
	public void debugPeg(int num) {
		int y = getyPos();
		int x = getxPos();
		System.out.println("Peg number: " + num + " y: " + y + " x: " + x);
	}
	public int getyPos() {
		return yPos;
	}
	public void setyPos(int yPos) {
		this.yPos = yPos;
	}
	public int getxPos() {
		return xPos;
	}
	public void setxPos(int xPos) {
		this.xPos = xPos;
	}
	public int getXvel() {
		return Xvel;
	}
	public void setXvel(int xvel) {
		Xvel = xvel;
	}
	public int getYvel() {
		return Yvel;
	}
	public void setYvel(int yvel) {
		Yvel = yvel;
	}
	public double getGravity() {
		return gravity;
	}
	public void setGravity(double gravity) {
		this.gravity = gravity;
	}
	private int Xvel, Yvel;
	private double gravity = 0.5;
}
