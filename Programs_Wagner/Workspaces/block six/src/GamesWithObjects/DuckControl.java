package GamesWithObjects;

public class DuckControl {
	private int Xpos ;
	private int Ypos;
	private int Yspeed;
	private int Xspeed ;
	public int count ;
	public int escape, dead ;
	public int score = 0;
	public DuckControl() {
		Xpos = (int)(Math.random()*800)+1;
		Ypos = (int)(Math.random()*800)+1;
		if(Math.random()<.5)
			Yspeed = 3;
		else
			Yspeed = -3;
		if(Math.random()<.5)
			Xspeed = 3;
		else
			Xspeed = -3;
		count = 0;
		escape = 0;
		dead = 0;

			
		
	}
public int getXpos() {
	Xpos+=Xspeed;
	System.out.println(count);
	shot();
if(count>=5) {
	count = 0;
	escape = 1;
	Yspeed = -3;
	Xspeed = 0;
}else{
	if(count <0) {
		count = 0;
		escape = 1;
		Yspeed = 3;
		Xspeed = 0;
		dead = 1;
	}

}

	   if(escape ==0) {
		   if (Xpos < 0 || Xpos > 790 - 50 ) {
		        Xpos = Math.max(0, Math.min(Xpos, 790 - 50));
		        Xspeed = -Xspeed;
		        count +=1;
	   }

	    }
	return Xpos;
}

public int getYpos() {
	Ypos+=Yspeed;
	if(escape ==0) {
    if (Ypos < 0 || Ypos > 790 - 50 ) {
        Ypos = Math.max(0, Math.min(Ypos, 790 - 50));
        Yspeed = -Yspeed;
        count += 1;
    }
	}
	return Ypos;
}

public void shot() {
	if(dead == 1 && Ypos > 900) {
		dead = 0;
		escape = 0;
		Xpos = (int)(Math.random()*800)+1;
		Ypos = (int)(Math.random()*800)+1;
		if(Math.random()<.5)
			Xspeed = 3;
		else
			Xspeed = -3;
		score ++;
	}else{
		if(escape == 1 && Ypos< -500) {
			escape = 0;
			Xpos = (int)(Math.random()*800)+1;
			Ypos = (int)(Math.random()*800)+1;
			score --;
			if(Math.random()<.5) {
				Xspeed = 3;
			}else {
				Xspeed = -3;
			}
		}
	}
}
public int getXspeed() {
	return Xspeed;
}
public String getScore() {
	String newScore = score + "";
	return newScore;
}
}
	
