package agario;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.Timer;


public class GameDriver {
	static JFrame f = new JFrame("Agario");
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			f.setTitle("agario");
			f.setSize(555,510);
			Game g = new Game();
			f.add(g);
			f.setVisible(true);
			Timer timer = new Timer(30, new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					g.gameLogic();
					g.repaint();
				}
			});
			timer.start();
		}
	}


