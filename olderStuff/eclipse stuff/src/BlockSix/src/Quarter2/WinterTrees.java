package Quarter2;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class WinterTrees extends JPanel{
	public static void main(String [] args) {
		JFrame frame = new JFrame();
		WinterTrees obj = new WinterTrees();
		frame.add(obj);
		frame.setTitle("Winter Trees");
		frame.setSize(500,500);
		frame.setVisible(true);
	}
	public void paint(Graphics g) {
	int [] xPoints = {50,250,450};
	int [] yPoints = {500,10,500};
	int nPoints = 3;
	g.setColor(Color.magenta);
	g.fillPolygon(xPoints, yPoints, nPoints);
	}

}
