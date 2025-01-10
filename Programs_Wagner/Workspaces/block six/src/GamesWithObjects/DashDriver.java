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

public class DashDriver extends JPanel implements KeyListener, MouseListener, MouseMotionListener{
	private boolean start = false;
	static Image back,square,triangle;
	private int lost = 0;
	private int count = 0;
	private String lostString;
	square s = new square();
	triangle t = new triangle();
	static triangle []tri = new triangle [50];
	public static void main(String [] args)throws InterruptedException {
		DashDriver game = new DashDriver();	
		JFrame gui = new JFrame();
		gui.add(game);
		gui.setSize(600,600);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Dash Driver");
		gui.setVisible(true);
		gui.addKeyListener(game);
		gui.addMouseListener(game);
		gui.addMouseMotionListener(game);
		ImageIcon triangleic = new ImageIcon("triangle.png");
		triangle = triangleic.getImage();	
		for(int k = 0; k<tri.length; k++) {
			tri[k] = new triangle();
		}
		while(true) {
			gui.repaint();
			Thread.sleep(50);
		}
	}
	public void paint(Graphics g) {

		if(start == false) {
			g.setColor(Color.black);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.white);
			g.drawString("press space to start and j to jump", 200, 300);
			
		}else {
			g.setColor(Color.orange);
			g.fillRect(0, 0, 600, 600);
			g.setColor(Color.black);
			g.fillRect(0, 300, 600, 600);
			g.setColor(Color.green);
			s.moveyPos();
			g.fillRect(s.getXpos(), s.getYpos(), 50, 50);
			g.setColor(Color.red);

			g.setColor(Color.white);
			lostString = Integer.toString(lost);
			g.drawString("Lost: " + lostString, 10, 10);
			for(int k = 0; k<tri.length; k++) {
				//tri[k] = new triangle();
				g.drawImage(triangle,tri[k].getXpos(), tri[k].getYpos(), 50, 50, this);
			}
			
		}
		for(int k = 0; k<tri.length; k++) {
		double distance = Math.sqrt(Math.pow(tri[k].getXpos() - s.getXpos(), 2) + Math.pow(tri[k].getYpos() - s.getYpos(), 2));
		if(distance < 25) {			
			start = false;
			//lost++;
			//t.setXpos(600);


		}

		}

	}
	public void keyTyped(KeyEvent e) {
		if(e.getKeyCode() == 0){
			start = true;
			if(count >0) {
				lost++;
			}else {
				count++;
			}
		}
		

	}
	public void keyPressed(KeyEvent e) {
		if(e.getKeyChar() == 'j') {
			s.jump(true);
		}
	}
	public void keyReleased(KeyEvent e) {
		
	}
	public void collision() {
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
