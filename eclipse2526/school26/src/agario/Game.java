package agario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Game extends JPanel implements MouseMotionListener, MouseListener{
	Player pl = new Player();
	private ArrayList<Food> blob = new ArrayList<>();
	private ArrayList<TurtleBullet> bull = new ArrayList<>();
	
	Enemy test = new Enemy();
	int xMB, xCLICK;
	int yMB, yCLICK;
	int offset = 15;
	int distance;
	int lSpeedX = 1;
	int lSpeedY = 1;
	boolean jump = false;
	static Image turtle;
	
	
	public int distance(int x1, int x2, int y1, int y2) {
		int exes = (x1-x2)*(x1-x2);
		int whys = (y1-y2)*(y1-y2);
		
		return (int)Math.sqrt(exes+whys);
	}
	public void gameLogic() {
		double math;
		for(int i = 0; i< bull.size()-1; i++) {
			bull.get(i).update();
			}
		//Set Player Velocity
		pl.setxVel((xMB-250)/20);
		pl.setyVel((yMB-250)/20);
		
		//Player Position Update
		pl.setxPos(pl.getxPos()+pl.getxVel());
		pl.setyPos(pl.getyPos()+pl.getyVel());
		test.setxPos(test.getxPos()-pl.getxVel());
		test.setyPos(test.getyPos()-pl.getyVel());
		
		for(int i = 0; i<blob.size(); i++) {
			if(blob.get(i).getActive()) {
				System.out.println(pl.getyPos()+" "+ (blob.get(i).getY()-239) +" "+ (pl.getyPos() +pl.getHeight()));
				System.out.println(pl.getxPos()+" "+ (blob.get(i).getX()-239) +" "+ (pl.getxPos() +pl.getWidth()-30));
				//if(pl.getxPos() < (blob.get(i).getX()-239)-pl.getxPos() && blob.get(i).getX()-239< (pl.getxPos() +pl.getWidth()))
				if(pl.getxPos() < (blob.get(i).getX()-229) && blob.get(i).getX()-229 < (pl.getxPos() +pl.getWidth()))
				{
					System.out.println("hit X");
					if(pl.getyPos() < blob.get(i).getY()-229 && blob.get(i).getY()-239 < (pl.getyPos() + pl.getHeight())) {
						System.out.println("hit");
						blob.get(i).setActive(false);
					blob.add(new Food());
					//pl.setWidth(pl.getWidth()+blob.get(i).getWidth());
					//pl.setHeight(pl.getHeight()+blob.get(i).getHeight());
					}
					
					
				
			}
		}
		}
		
		if(test.getxPos()-15 < pl.getxPos()+(offset)/2) {
			test.setxPos(test.getxPos()+1);
		}else if(test.getxPos()-15 == pl.getxPos()+(offset)/2){
			
		}else {
			test.setxPos(test.getxPos()-1);
		}
		if(test.getyPos()-15 < pl.getyPos()+(offset)/2) {
			test.setyPos(test.getyPos()+1);
		}else if(test.getyPos()-15 == pl.getyPos()+(offset)/2){
			
		}else {
			test.setyPos(test.getyPos()-1);
		}
		if(distance(pl.getxPos()+(offset/2), test.getxPos(), pl.getyPos()+(offset/2), test.getyPos()) < 40){
			
		//	pl.setWidth(pl.getWidth()+blob[i].getWidth());
		//	pl.setHeight(pl.getHeight()+blob[i].getHeight());
			//offset+=5;
			System.out.println("killed");
		}
	}
	
	public void paint(Graphics p) {
		p.setColor(Color.blue);
		
		//Horizontal
		for(int i = -5000; i<= 5000; i+=40) 
		{
			p.drawLine(0, i-pl.getyPos(), 2000, i-pl.getyPos());	
		}
		
		//Vertical
		for(int i = -5000; i<= 5000; i+=40) 
		{
			p.drawLine(i-pl.getxPos(), 0, i-pl.getxPos(), 2000);		
		}
		
		p.setColor(new Color(222,200,175));
		p.fillRect(250-15,250-15,pl.getWidth(),pl.getHeight());
		for(int i = 0; i<blob.size(); i++) {
			if (blob.get(i).getActive() == true){
				p.setColor(new Color(blob.get(i).getR(),blob.get(i).getG(),blob.get(i).getB()));
				p.fillOval(blob.get(i).getX()-pl.getxPos(),blob.get(i).getY()-pl.getyPos(),blob.get(i).getWidth(),blob.get(i).getHeight());
			}
		
		}
		
		p.setColor(Color.red);
		p.fillOval(test.getxPos(), test.getyPos(), test.getHeight(), test.getWidth());
		for(int i = 0; i< bull.size(); i++) {
			bull.get(i).setxPos(bull.get(i).getxPos() + bull.get(i).getxSpeed());
			bull.get(i).setyPos(bull.get(i).getyPos() + bull.get(i).getySpeed());
		p.drawImage(bull.get(i).getTurtle(), bull.get(i).getxPos()-pl.getxPos(),bull.get(i).getyPos()-pl.getyPos(), 40, 40, this);
		bull.get(i).update();
		
		}
		System.out.println(pl.getxPos() + " " + pl.getyPos());
		
	}
	
	public Game() {
		addMouseMotionListener(this);
		addMouseListener(this);
		//bull.add(new TurtleBullet(pl.getxPos(),pl.getyPos()));
		for(int i = 0; i< 700; i++) {
			blob.add(new Food());
		}
		
		
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		xMB = e.getX();
		yMB = e.getY();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		xCLICK = e.getX();
		yCLICK = e.getY();
		System.out.println(xCLICK);
		System.out.println(yCLICK);
		//System.exit(0);
		int ytoset = 0;
		int xtoset = 0;
		if(xCLICK > 222) {
			xtoset = 30;
		}else {
			xtoset = -30;
			
		}
		if(yCLICK > 222) {
			ytoset = 30;
		}else {
			ytoset = -30;
			
		}
		bull.add(new TurtleBullet((pl.getxPos()+pl.getxVel())+200, (pl.getyPos()+pl.getyVel())+200, xtoset, ytoset));
		
	
		
		
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
