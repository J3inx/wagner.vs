package Qaurter1;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class fiftywaystoleave extends JPanel
{
	
	public static void main(String [] args)throws InterruptedException
	{
		
		fiftywaystoleave game1 = new fiftywaystoleave();
		//makes game
		JFrame frame = new JFrame("Thousands of Colorful squares");
		//makes outline
		frame.add(game1);
		//puts game inside frame
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);		
	}

	public void paint(Graphics g)
	{
		g.setColor(Color.red);
		g.drawRect(88, 12, 66, 66);
		g.fillRect(500, 300, 99, 33);
		int xPos = (int) (Math.random()*800);
		int yPos = (int) (Math.random()*600);
		g.setColor(new Color(50,250,45));
		g.fillOval(xPos, yPos, 50, 50);
		int count = 1;
		int col1 = (int) (Math.random()*255);
		int col2 = (int) (Math.random()*255);
		int col3 = (int) (Math.random()*255);
		while(count<1001) 
		{
			xPos = (int) (Math.random()*800);
			yPos = (int) (Math.random()*600);
			col1 = (int) (Math.random()*255);
			col2 = (int) (Math.random()*255);
			col3 = (int) (Math.random()*255);
			g.setColor(new Color(col1, col2, col3));
			g.fillOval(xPos, yPos, 50, 50);
			count++;
			
		}
	}
}
