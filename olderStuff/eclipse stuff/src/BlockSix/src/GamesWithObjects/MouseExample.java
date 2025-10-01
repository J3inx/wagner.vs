package GamesWithObjects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MouseExample extends JPanel implements MouseListener {
	//2 global variables
	int x = 10;
	int y = 10;
	public static void main(String [] args) throws InterruptedException {
		MouseExample game = new MouseExample();
		JFrame gui = new JFrame();
		gui.setTitle("mouse moves");
		gui.setSize(400,400);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.add(game);
		gui.addMouseListener(game);
		gui.setVisible(true);
		while(true) {
			gui.repaint();
			Thread.sleep(5);
		}
	}
	public void paint(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 35, 35);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		x = e.getX();
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
}
