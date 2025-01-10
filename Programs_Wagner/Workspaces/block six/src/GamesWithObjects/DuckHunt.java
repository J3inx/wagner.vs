package GamesWithObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DuckHunt extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	DuckControl duck = new DuckControl();
	int mouseX = 50;
	int mouseY = 50;
	static Image back, cross, Duck;
	int score = 0;
	int b = 0;
	int y = 0;
	private static int x = 1;
	public static void main(String [] args)throws InterruptedException {
		DuckHunt game = new DuckHunt();	
		JFrame gui = new JFrame();
		gui.add(game);
		gui.setSize(810,800);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("duck hunt");
		gui.setVisible(true);
		gui.addKeyListener(game);
		gui.addMouseListener(game);
		gui.addMouseMotionListener(game);
		ImageIcon backIcon = new ImageIcon("background.jpeg");
		back = backIcon.getImage();
		ImageIcon crossIcon = new ImageIcon("cross.png");
		cross = crossIcon.getImage();
		ImageIcon DuckImage = new ImageIcon("duck.png");
		Duck = DuckImage.getImage();
		while(1 == x) {
			gui.repaint();
			Thread.sleep(10);
			
		}
	}
	public void paint (Graphics g) {
		int l = 0;
		if(duck.getXspeed() > 0) {
			l = 50;
		}else {
		l = -50;
	}
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 800);
		g.setColor(Color.WHITE);
		g.setColor(Color.YELLOW);	
		g.fillRect(0, 0, 10, 800);
		g.fillRect(0, 0, 800, 10);
		g.fillRect(800, 0, 10, 800);
		g.drawImage(back, 0, 0, 810, 800, this);
		g.setColor(Color.BLACK);
		g.drawImage(Duck, duck.getXpos(), duck.getYpos(), l, 50, this);
		g.setColor(Color.RED);
		g.drawImage( cross, mouseX, mouseY, 40, 40, this);
		g.drawString(duck.getScore(), 10, 10);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == 32){
			if(mouseX< duck.getXpos()+100 && mouseX>duck.getXpos()) {
				if(mouseY< duck.getYpos()+100 && mouseY>duck.getYpos()) {
					duck.count = -5;
				}
				}
			}
		
		}
	

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		b = e.getX();
		y = e.getY();
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
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX=e.getX()-20;
		mouseY=e.getY()-60;
	}

}
