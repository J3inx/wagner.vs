package GamesWithObjects;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class MyKeyListener implements KeyListener {

	private static int ySpeed;
	private static int xPos, yPos;
	private String name;
	private static int x = 1;
	   private static boolean aPressed, dPressed;
public MyKeyListener(){
	ySpeed = 0;
	yPos = 700;

}
	@Override
	   public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            aPressed = true;
        } else if (e.getKeyChar() == 'd') {
            dPressed = true;
        }
    }

	@Override
	 public void keyReleased(KeyEvent e) {
        if (e.getKeyChar() == 'a') {
            aPressed = false;
        } else if (e.getKeyChar() == 'd') {
            dPressed = false;
        }
    }

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}


	  public static int xPos() {
	        if (aPressed && xPos>10) {
	            xPos -= 2;  // Move up
	        } else if (dPressed&& xPos<600) {
	            xPos += 2;  // Move down
	        }
	        // else both keys are released, do nothing
	        return xPos;
	    }
			

		
public static int getYpos() {
	return yPos;
}

public static int getXpos() {
	return xPos;
}
}



	


