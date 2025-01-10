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

public class kaboomDriver extends JPanel implements KeyListener, MouseListener, MouseMotionListener {
	private static int x = 1;
	static Image dude, bomb, Bucket;
	private int lives = 3;
	DudeControl Dude = new DudeControl();
	bucketControl bucket = new bucketControl();
	bombController Bomb = new bombController();
	private int pos;
	private int speed;
	private int posot;
	public static void main(String [] args)throws InterruptedException {

		kaboomDriver game = new kaboomDriver();	
		JFrame gui = new JFrame();
		gui.add(game);
		gui.setSize(810,800);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("Kaboom!");
		gui.setVisible(true);
		gui.addKeyListener(game);
		gui.addMouseListener(game);
		gui.addMouseMotionListener(game);
		ImageIcon dudeIcon = new ImageIcon("dude.png");
		dude = dudeIcon.getImage();		
		ImageIcon bucketsIcon = new ImageIcon("buckets3.png");
		Bucket = bucketsIcon.getImage();
		
		while(1 == x) {
			gui.repaint();
			Thread.sleep(50);
			
			
		}
	}

	public void paint (Graphics g) {
		pos = Dude.Xpos;
		if(Math.random() > 0.5) {
			Bomb.drop();
		}
	g.setColor(new Color(58,109,4));
	g.fillRect(0,0,800,800);
	g.setColor(new Color(119,119,119));
	g.fillRect(0, 0, 800, 200);
	g.setColor(Color.ORANGE);
	g.fillRect(Bomb.getXpos(), Bomb.getYpos(), 50, 50);
	g.drawImage(dude, Dude.getXpos()-45,-30, 300, 300, this);
	double distance = Math.sqrt(Math.pow(Bomb.getXpos() - bucket.getXpos(), 2) + Math.pow(Bomb.getYpos() - bucket.getYpos(), 2));

	if(Bomb.getYpos() > 650) {
		if(distance < 100) {
		Bomb.setActive();
		}
		
	}
	if(lives == 3) {
		ImageIcon bucketsIcon = new ImageIcon("buckets3.png");
		Bucket = bucketsIcon.getImage();
	}else {
		if(lives ==2) {
			ImageIcon bucketsIcon = new ImageIcon("buckets2.png");
			Bucket = bucketsIcon.getImage();
		}else {
			ImageIcon bucketsIcon = new ImageIcon("buckets1.png");	
			Bucket = bucketsIcon.getImage();
		}
	}
	g.drawImage(Bucket, posot, bucket.getYpos()+685, 100, 100, this);
	System.out.println(pos);
	
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		posot = e.getX();
		
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

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyChar() == 'a') {
			
		}
		if(e.getKeyChar() == 'd') {
			
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void help() throws InterruptedException {
		while(true) {
			Dude.getXpos();
		}
	}

}
