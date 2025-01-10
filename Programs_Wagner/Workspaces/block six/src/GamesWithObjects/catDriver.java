package GamesWithObjects;

import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

public class catDriver extends JPanel implements KeyListener {
	//MyKeyListener blocker1 = new MyKeyListener();

	CatControl cat = new CatControl();
	MouseControl mouse = new MouseControl();
	int score = 0;
	private static int x = 1;
	public static void main(String [] args)throws InterruptedException {
		catDriver game = new catDriver();	
		JFrame gui = new JFrame();

	gui.add(game);
	gui.setSize(810,800);
	gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	gui.setTitle("Cat In Living Room");
	gui.setVisible(true);
	gui.addKeyListener(game);
	
	while(1 == x) {
		gui.repaint();
		Thread.sleep(10);
		
	}
 
	}
	public void paint (Graphics g) {

	g.setColor(Color.BLACK);
	g.fillRect(0, 0, 800, 800);
	g.setColor(Color.WHITE);
	g.setColor(Color.YELLOW);	
	g.fillRect(0, 0, 10, 800);
	g.fillRect(0, 0, 800, 10);
	g.fillRect(800, 0, 10, 800);
	g.setColor(Color.BLUE);
	g.fillOval(cat.getXpos(),cat.getYpos(),50,50);
	
	g.setColor(Color.WHITE);
	g.fillRect(350, 250, 150, 300);
	g.setColor(Color.GREEN);
	g.fillRect(mouse.getXpos(),mouse.getYpos(), 50, 50);

	double distance = Math.sqrt(Math.pow(cat.getXpos() - mouse.getXpos(), 2) + Math.pow(cat.getYpos() - mouse.getYpos(), 2));

	if(distance < 50) {
		//this was just a test
		collision();
	}
	}
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a') {
			cat.setXpos(-5);
			mouse.setXpos(5);
		}
		if(e.getKeyChar() == 'd') {
			cat.setXpos(5);
			mouse.setXpos(5);
		}
		if(e.getKeyChar() == 'w') {
			cat.setYpos(-5);
			mouse.setYpos(5);
		}
		if(e.getKeyChar() == 's') {
			cat.setYpos(5);
			mouse.setYpos(5);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a') {
			cat.setXpos(0);
		}
		if(e.getKeyChar() == 'd') {
			cat.setXpos(0);
		}
		if(e.getKeyChar() == 'w') {
			cat.setYpos(0);
		}
		if(e.getKeyChar() == 's') {
			cat.setYpos(0);
		}
	
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void collision()
	{
		System.out.println(cat.getXpos() + "||" + mouse.getXpos() + "||" + cat.getYpos() + "||" + mouse.getYpos());
		if((cat.getXpos() - mouse.getXpos()) < 10 && (cat.getYpos() - mouse.getYpos()) <10) {
			x=0;
		}
		System.out.println(x);
	}
	
	
	

}
