package GamesWithObjects;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TankDriver extends JPanel implements KeyListener {
tank tank = new tank();
tankTwo tank2 = new tankTwo();
tankBody tankB = new tankBody();
	public static void main(String [] args) throws InterruptedException {
		TankDriver game = new TankDriver();
		JFrame gui = new JFrame();
		gui.setSize(800,800);
		gui.setTitle("Sad Tank Game");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setFocusable(true);
		gui.requestFocus();
		gui.add(game);
		gui.addKeyListener(game);
		gui.setVisible(true);
		while(true) {
			gui.repaint();
			Thread.sleep(5);
		}
	}
	public void paint(Graphics g) {
		Dimension size = getSize();
		g.setColor(new Color(33,200,15));
		//g.fillRect(0, 0, (int)size.getWidth(), (int)size.getHeight());
		g.fillRect(0, 0, size.width, size.height);
		g.setColor(Color.black);
		g.fillOval(tank.getXwheelPos(), tank.getYwheelPos(), 20, 20);
		g.fillOval(tank2.getXwheelPos(), tank2.getYwheelPos(), 20, 20);
		g.fillRect(tankB.getXPos(), tankB.getYPos(), 70, 20);
		
	}
	public void keyTyped(KeyEvent e) {
		if(e.getKeyChar()=='d') {
			tank.setXwheelSpeed(5);
			tank2.setXwheelSpeed(5);
			tankB.setXSpeed(5);
		}
		if(e.getKeyChar()=='a') {
			tank.setXwheelSpeed(-5);
			tank2.setXwheelSpeed(-5);
			tankB.setXSpeed(-5);
		}
		if(e.getKeyChar()=='w') {
			tank.setYwheelSpeed(-5);
			tank2.setYwheelSpeed(-5);
			tankB.setYSpeed(-5);
		}
		if(e.getKeyChar()=='s') {
			tank.setYwheelSpeed(5);
			tank2.setYwheelSpeed(5);
			tankB.setYSpeed(5);
		}
		
	}
	public void keyPressed(KeyEvent e) {

		
	}
	public void keyReleased(KeyEvent e) {

		
	}

}
