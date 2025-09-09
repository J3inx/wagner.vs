package superMeatBoy;



import javax.swing.JFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class DriverSuperMeatBoy {
	static JFrame f = new JFrame("Super Meat Boy");
	public static void main(String[] args) {
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Super Meat Boy");
		f.setSize(555,510);
		Game g = new Game();
		f.add(g);
		f.setVisible(true);
		Timer timer = new Timer(33, new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				g.gameLogic();
				g.repaint();
			}
		});
		timer.start();
	}

}
