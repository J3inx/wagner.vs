package GamesWithObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JumpingGirl extends JPanel implements KeyListener {
	public int x = 100, y = 300,xSpeed = 0, ySpeed = 0;
	private int gravity = -25;
	private int ground = 300;
	private boolean jumped = false;
	static RainDrops []r = new RainDrops [50];
	public static void main(String [] args) throws InterruptedException 
	{	
	JumpingGirl game = new JumpingGirl();
	JFrame gui = new JFrame();
	gui.setSize(400,400);
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.add(game);
	gui.addKeyListener(game);
	gui.setVisible(true);
	for(int k =0; k<r.length; k++) {
		r[k] = new RainDrops();
	}
	while(true) {
		gui.repaint();
		Thread.sleep(10);
	}
	}
	public void paint(Graphics g) {
		if(jumped == true) {
			y +=gravity;
			gravity += 1;
		}
		if(y >300) {
			jumped = false;
			y = ground;
			gravity = -25;
		}
		x = x+xSpeed;
		y+=ySpeed;
		g.setColor(Color.red);
		g.drawOval(x, y, 50, 50);
		g.setColor(Color.blue);
		for(int k =0; k<r.length; k++) {
			g.drawOval(r[k].getXpos(), r[k].getYpos(), r[k].getSize(), r[k].getSize());
			r[k] = new RainDrops();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a'){
			xSpeed = -1;
		}
		if(e.getKeyChar() == 'd') {
			xSpeed = 1;
		}
		if(e.getKeyChar() == 'j') {
			jumped = true;
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a'){
			xSpeed = -0;
		}
		if(e.getKeyChar() == 'd') {
			xSpeed = 0;
		}
	}
	

}

