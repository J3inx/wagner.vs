package agario;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class Game extends JPanel implements MouseMotionListener, MouseListener{
	Player pl = new Player();
	private ArrayList<Food> blob = new ArrayList<>();
	
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
		for(int i = 0; i<blob.size(); i++) {
			
			if(Math.sqrt(math = (((blob.get(i).getX()-pl.getxPos()-10)*(blob.get(i).getX()-pl.getxPos()-10)))+((blob.get(i).getY()-pl.getyPos()-10)*(blob.get(i).getY()-pl.getyPos()-10)))<offset+8){
				blob.get(i).setX(900);
				blob.get(i).setY(900);
				blob.add(new Food());
				pl.setWidth(pl.getWidth()+blob.get(i).getWidth());
				pl.setHeight(pl.getHeight()+blob.get(i).getHeight());
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
		for(int i = 0; i<blob.size()-1; i++) {
		p.setColor(new Color(blob.get(i).getR(),blob.get(i).getG(),blob.get(i).getB()));
		p.fillOval(blob.get(i).getX(),blob.get(i).getY(),blob.get(i).getWidth(),blob.get(i).getHeight());
		}
		p.setColor(Color.red);
		p.fillOval(test.getxPos(), test.getyPos(), test.getHeight(), test.getWidth());
		
		
	}
	
	public Game() {
		addMouseMotionListener(this);
		addMouseListener(this);
		blob.add(new Food());
		blob.add(new Food());
		blob.add(new Food());
		blob.add(new Food());
		blob.add(new Food());
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
