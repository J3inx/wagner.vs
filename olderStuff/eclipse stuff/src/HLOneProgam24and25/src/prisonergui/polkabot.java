package prisonergui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class polkabot extends JPanel {
	public static void main(String [] args) {
		JFrame gui = new JFrame();
		polkabot picture = new polkabot();
		gui.add(picture);
		gui.setVisible(true);
		gui.setSize(800,600);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gui.setTitle("random colors");
		
		
	}
	public void paint(Graphics g) {
		g.setColor(Color.green);
		for(int i = 0; i <20; i++) {
			int x= (int)(Math.random()*400);
			int y= (int)(Math.random()*400);
			int z= (int)(Math.random()*400);
			int c= (int)(Math.random()*400);
			g.drawOval(x,y,z,c);
			g.setColor(new Color((int)((Math.random())*256),(int)((Math.random())*256),(int)((Math.random())*256)));
			g.fillOval(x,y,z,c);
			
		}
	}
}
