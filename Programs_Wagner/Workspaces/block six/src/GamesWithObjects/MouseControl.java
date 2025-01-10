package GamesWithObjects;

public class MouseControl {
    private int Xpos = 700;
	CatControl cat = new CatControl();
	private int Xspeed = 0;
	private int Yspeed = 0;
    private int Ypos = 700;
    private int targetX = -1; 
    private int targetY = -1; 
    private boolean active = true;
    private int choice; 
    private int rectX = 350;
    private int rectY = 250;
    private int rectWidth = 150;
    private int rectHeight = 300;
    public void main(String [] args) {
    	Yspeed = cat.Yspeed();
    	Xspeed = cat.Xspeed();
    }
    public int getXpos() {
        Xpos += Xspeed;
        if (Xpos < 0 || Xpos > 790 - 50 || (Xpos + 50 > rectX && Xpos < rectX + rectWidth && Ypos + 50 > rectY && Ypos < rectY + rectHeight)) {
            Xpos = Math.max(0, Math.min(Xpos, 790 - 50));
            Xspeed = -Xspeed;
        }

        return Xpos;
    }

    public int getYpos() {

        Ypos += Yspeed;
        if (Ypos < 0 || Ypos > 790 - 50 || (Xpos + 50 > rectX && Xpos < rectX + rectWidth && Ypos + 50 > rectY && Ypos < rectY + rectHeight)) {
            Ypos = Math.max(0, Math.min(Ypos, 790 - 50));
            Yspeed = -Yspeed;
        }

        return Ypos;
    }

public void setXpos(int brody) {

Xspeed=brody;


}
public void setYpos(int brady) {
  Yspeed=brady;
	

}
public int Yspeed() {
return Yspeed;
}
public int Xspeed() {
return Xspeed;
}



}
