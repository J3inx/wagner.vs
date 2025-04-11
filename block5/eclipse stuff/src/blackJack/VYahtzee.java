package blackJack;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class VYahtzee extends JPanel{
	
	public static void main(String [] args) throws InterruptedException{
		JFrame gui = new JFrame();
		VYahtzee game = new VYahtzee();
		gui.add(game);
		gui.setSize(800,800);
		gui.setTitle("visual yahtzee");
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setVisible(true);
	}
}
