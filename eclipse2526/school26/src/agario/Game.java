package agario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Game extends JPanel implements MouseMotionListener, MouseListener{
	Player pl = new Player();
	Food [] blob = new Food[5];
	Enemy test = new Enemy();
	int xMB;
	int yMB;
	int offset = 15;
	int distance;
	boolean jump = false;
	public static void main(String [] args) {
		
		
		
		
	}
	public int distance(int x1, int x2, int y1, int y2) {
		int exes = (x1-x2)*(x1-x2);
		int whys = (y1-y2)*(y1-y2);
		
		return (int)Math.sqrt(exes+whys);
	}
	public void gameLogic() {
		double math;
		pl.setxPos(xMB-offset);
		pl.setyPos(yMB-offset);
		for(int i = 0; i<5; i++) {
			
			if(Math.sqrt(math = (((blob[i].getX()-pl.getxPos()-10)*(blob[i].getX()-pl.getxPos()-10)))+((blob[i].getY()-pl.getyPos()-10)*(blob[i].getY()-pl.getyPos()-10)))<offset+8){
				blob[i].setX(900);
				blob[i].setY(900);
				pl.setWidth(pl.getWidth()+blob[i].getWidth());
				pl.setHeight(pl.getHeight()+blob[i].getHeight());
				offset+=5;
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
		p.setColor(new Color(222,200,175));
		p.fillRect(pl.getxPos(),pl.getyPos(),pl.getWidth(),pl.getHeight());
		for(int i = 0; i<5; i++) {
		p.setColor(new Color(blob[i].getR(),blob[i].getG(),blob[i].getB()));
		p.fillOval(blob[i].getX(),blob[i].getY(),blob[i].getWidth(),blob[i].getHeight());
		}
		p.setColor(Color.red);
		p.fillOval(test.getxPos(), test.getyPos(), test.getHeight(), test.getWidth());
		
		
	}
	
	public Game() {
		addMouseMotionListener(this);
		addMouseListener(this);
		blob [0] = new Food();
		blob [1] = new Food();
		blob[2] = new Food();
		blob[3] = new Food();
		blob[4] = new Food();
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
