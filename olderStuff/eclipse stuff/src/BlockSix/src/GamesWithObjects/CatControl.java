package GamesWithObjects;

public class CatControl {
    private int Xspeed, Yspeed, Xpos, Ypos;
    private int rectX = 350;
    private int rectY = 250;
    private int rectWidth = 150;
    private int rectHeight = 300;
    private int catWidth = 50;
    private int catHeight = 50;

    public void temp() {
        Xspeed = 0;
        Yspeed = 0;
    }

    public CatControl() {
        Xpos = 20;
        Ypos = 20;
    }

    public int getXpos() {
        Xpos += Xspeed;
        if (Xpos + catWidth > rectX && Xpos < rectX + rectWidth && Ypos + catHeight > rectY && Ypos < rectY + rectHeight) {
            if (Xspeed > 0) {
                Xpos = rectX - catWidth;
            } else if (Xspeed < 0) {
                Xpos = rectX + rectWidth;
            }
        } else {
            if (Xpos < 0) {
                Xpos = 0;
            } else if (Xpos > 790 - catWidth) {
                Xpos = 790 - catWidth;
            }
        }
        return Xpos;
    }

    public int getYpos() {
        Ypos += Yspeed;
        if (Xpos + catWidth > rectX && Xpos < rectX + rectWidth && Ypos + catHeight > rectY && Ypos < rectY + rectHeight) {
            if (Yspeed > 0) {
                Ypos = rectY - catHeight;
            } else if (Yspeed < 0) {
                Ypos = rectY + rectHeight;
            }
        } else {
            if (Ypos < 0) {
                Ypos = 0;
            } else if (Ypos > 790 - catHeight) {
                Ypos = 790 - catHeight;
            }
        }
        return Ypos;
    }

    public void setXpos(int brody) {
        Xspeed = brody;
    }

    public void setYpos(int brady) {
        Yspeed = brady;
    }

    public int Yspeed() {
        return Yspeed;
    }

    public int Xspeed() {
        return Xspeed;
    }
}
