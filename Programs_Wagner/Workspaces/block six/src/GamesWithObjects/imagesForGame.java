package GamesWithObjects;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class imagesForGame extends JPanel implements MouseMotionListener{
	int mouseX = 50;
	int mouseY = 50;
	static Image back, cross;
	public static void main(String [] args) throws InterruptedException {
		imagesForGame game = new imagesForGame();
		JFrame gui = new JFrame();
		gui.setTitle("duck hunt images");
		gui.setSize(500,500);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.add(game);
		gui.addMouseMotionListener(game);
		gui.setVisible(true);
		ImageIcon backIcon = new ImageIcon("background.jpeg");
		back = backIcon.getImage();
		ImageIcon crossIcon = new ImageIcon("cross.png");
		cross = crossIcon.getImage();
		while(true) {
			gui.repaint();
			Thread.sleep(5);
		}
		
		
	}
	public void paint(Graphics g) {
		g.drawImage(back, 0, 0, 500, 500, this);
		g.drawImage( cross, mouseX, mouseY, 40, 40, this);
	}
	public void mouseDragged(MouseEvent e) {
		
		
	}

	public void mouseMoved(MouseEvent e) {
		mouseX=e.getX()-20;
		mouseY=e.getY()-60;
		
	}

}
