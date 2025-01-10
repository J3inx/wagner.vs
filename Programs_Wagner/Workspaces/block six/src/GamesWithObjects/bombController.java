package GamesWithObjects;

public class bombController {
	private boolean active = true;
	
	private int Yspeed = 40;
	DudeControl dude = new DudeControl();
	private int Xpos = dude.Ypos;
	private int Ypos = dude.getXpos();
	public void drop() {
	if(active == true) {
		Xpos = dude.Xpos;
		Ypos = dude.Ypos;
		active = false;
	}
	if(Ypos > 800) {
		active = true;
		Yspeed = 40;
	}
	}
	public int getXpos() {
		return Xpos;
	}
	public int getYpos() {
		return Ypos += Yspeed;
	}
	public void setActive() {
		active = true;
	}
}
