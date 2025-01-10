package GamesWithObjects;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class PongDriver extends JPanel{
	MyKeyListener blocker1 = new MyKeyListener();
	Ball ball1 = new Ball();
	Ball ball2 = new Ball();
	Blocker blocker2 = new Blocker();
	int score = 0;
	public static void main(String [] args)throws InterruptedException {
		JFrame gui = new JFrame();
	PongDriver game = new PongDriver();	
	gui.add(game);
	gui.setSize(810,800);
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("PONG");
	gui.setVisible(true);
    gui.addKeyListener(new MyKeyListener());
	while(true == true) {
		gui.repaint();
		Thread.sleep(10);
	}
 
	}
	public void paint (Graphics g) {

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 800, 800);
	g.setColor(Color.WHITE);
	g.setFont(new Font("Sans Serif", Font.BOLD,36));
	g.drawString("score: " + score, 400, 100);
	g.setColor(Color.YELLOW);	
	g.fillRect(0, 0, 10, 800);
	g.fillRect(0, 0, 800, 10);
	g.fillRect(800, 0, 10, 800);
	g.setColor(new Color(ball1.getRed(), ball1.getGreen(),ball1.getBlue()));
	g.fillOval(ball1.getXpos(), ball1.getYpos(), 20, 20);
	g.setColor(new Color(ball2.getRed(), ball2.getGreen(),ball2.getBlue()));
	g.fillOval(ball2.getXpos(), ball2.getYpos(), 20, 20);
	g.setColor(Color.GREEN);
	//g.fillRect(blocker2.getXpos(), blocker2.getYpos(), 200, 10);
	//this is the version i made
	g.setColor(Color.WHITE);
	g.fillRect(MyKeyListener.xPos(), MyKeyListener.getYpos(), 200, 10);
	collision();


	}
	public void collision() {
		if(blocker1.getXpos()<ball1.getXpos() &&
				ball1.getXpos()<blocker1.getXpos()+200 &&
				blocker1.getYpos()<ball1.getYpos()&&
				ball1.getYpos()<blocker1.getYpos()+ 10) {
			ball1.setYspeed(-1);
		score++;
		}
		
		if(blocker1.getXpos()<ball2.getXpos() &&
				ball2.getXpos()<blocker1.getXpos()+200 &&
				blocker1.getYpos()<ball2.getYpos()&&
				ball2.getYpos()<blocker1.getYpos()+ 10) {
			ball2.setYspeed(-1);
		score++;
		}
	
		}
	}



