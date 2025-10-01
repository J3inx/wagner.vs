package GamesWithObjects;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;

public class DudeControl {
	int Xpos = 125 ;
	int Ypos = 0;
	private int Yspeed;
	private int Xspeed ;
	private int count = 0;
	private int tempCount = 0;
	private int position;
	private int currentPosition;
	double r;
	private int ello;
	private boolean go;
	private boolean gotwo;
	int delay = 1000;

	public void l(){
		while(true) {
			r = Math.random();
			if(gotwo == true) {
				go = true;
				gotwo = false;
			}
		}

	}
	public int getXpos() {
	    System.out.println(r);
	    int movesLeft = 10; 
	    while (movesLeft > 0) {
	    	if(movesLeft >=1) {
	    		ello = 200;
	    	}else {
	    		ello = 2000;
	    	}
	        r = Math.random();
	        if (r < 0.2) {
	            position = 1;
	        } else if (r < 0.4 && r > 0.20001) {
	            position = 2;
	        } else if (r < 0.6 && r > 0.4001) {
	            position = 3;
	        } else if (r < 0.8 && r > 0.6001) {
	            position = 4;
	        } else if (r < 1 && r > 0.80001) {
	            position = 5;
	        }
	        switch (position) {
	            case 1:
	                Xpos = 25;
	                break;
	            case 2:
	                Xpos = 150;
	                break;
	            case 3:
	                Xpos = 325;
	                break;
	            case 4:
	                Xpos = 650;
	                break;
	            case 5:
	                Xpos = 750;
	                break;
	        }
	        movesLeft--; 
	        try {
	            Thread.sleep(ello);
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
	    
	    return Xpos;
	}


	
	public void leftover() {
		tempCount --;
		if(tempCount <= 0) {
			count = 0;
		}
	}
	public int counter() {
		return count;
	}
	
}


