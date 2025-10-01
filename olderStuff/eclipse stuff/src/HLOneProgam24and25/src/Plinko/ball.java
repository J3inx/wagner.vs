package Plinko;

public class ball {
    private int xPos, yPos;
    private int colorOne, colorTwo, colorThree;
    private int Xvel = 0, Yvel = 0;

    // Constructor to initialize the ball with color and position
    public ball(int xPos, int yPos, int colorOne, int colorTwo, int colorThree) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.colorOne = colorOne;
        this.colorTwo = colorTwo;
        this.colorThree = colorThree;
    }

    // Getter and setter methods
    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    public int getColorOne() {
        return colorOne;
    }

    public int getColorTwo() {
        return colorTwo;
    }

    public int getColorThree() {
        return colorThree;
    }

    public int getXvel() {
        return Xvel;
    }

    public void setXvel(int Xvel) {
        this.Xvel = Xvel;
    }

    public int getYvel() {
        return Yvel;
    }

    public void setYvel(int Yvel) {
        this.Yvel = Yvel;
    }
}


